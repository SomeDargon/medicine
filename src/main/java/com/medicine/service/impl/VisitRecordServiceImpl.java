package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.VisitRecord;
import com.medicine.domain.attiendRecode.*;
import com.medicine.domain.converter.VisitRcodeToVisitRecordDTOConverter;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.attiendRecode.DataDTO;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import com.medicine.domain.repository.VisitRecordRepository;
import com.medicine.service.*;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;
    @Autowired
    private DiagnosisOfZhService diagnosisOfZhService;
    @Autowired
    private DiagnosisOfWeService diagnosisOfWeService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private PatientService patientService;
    @Override
    public VisitRecord save(VisitRecordForm visitRecordForm) {
        VisitRecord visitRecord = new VisitRecord();
        // 就诊次数 当前次数+1
        Integer time = visitRecordRepository.maxVisitTimes(visitRecordForm.getId()) + 1;
        visitRecord.setVisitTimes(time);

        Patient patient = patientService.findById(visitRecordForm.getId());
        patient.setTime(time);
        patientService.save(patient);

        visitRecord.setPatient(new Patient(visitRecordForm.getId()));
        // 把from 数据转换成实体类
        visitRecord.setDiagnosisAndtreatment(
                DiagnosisAndtreatmentFrom.dFromToD(
                        visitRecordForm.getDiagnosisAndtreatment()
                )
        );
        // 把中医四诊 提交的from 转换成实体 以下都是， 但是jpa在嵌套第二次的时候
        // 需要把实体把父级添加到子集里面去
        visitRecord.setDiagnosisOfZh(
                DiagnosisOfZhFrom.dZhFromToD(
                        visitRecordForm.getDiagnosisOfZh()
                )
        );
        visitRecord.setDiagnosisOfWe(
                DiagnosisOfWeFrom.dFromToD(
                        visitRecordForm.getDiagnosisOfWe()
                )
        );
        visitRecord.setOtherMessage(
                OrtherFrom.ortherFromToOtherMesage(visitRecordForm.getOrther())
        );
        return visitRecordRepository.save(visitRecord);
    }

    @Override
    public PatientRecodDTO findById(Long id) {
        PatientRecodDTO recodDTO = new PatientRecodDTO();
        // 返回信息由两部份组成： 一个是登记记录， 另一个用户信息
        Patient patient = patientService.findById(id);
        UserInfoDTO userInfoDTO = UserInfoDTO.patientToUserInfo(patient);

        List<VisitRecord> visitRecords = visitRecordRepository.findByPatientId(id);
        List<VisitRecordDTO> visitRecordDTOS = VisitRcodeToVisitRecordDTOConverter.convert(visitRecords);
        DataDTO dataDTO = new DataDTO();
        dataDTO.setData(visitRecordDTOS);
        recodDTO.setHistoryData(dataDTO);
        recodDTO.setInfo(userInfoDTO);
        return recodDTO;
    }
}
