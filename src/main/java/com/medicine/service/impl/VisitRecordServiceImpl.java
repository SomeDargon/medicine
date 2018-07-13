package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.VisitRecord;
import com.medicine.domain.converter.VisitRcodeToVisitRecordDTOConverter;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.dto.attiendRecode.DataDTO;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import com.medicine.domain.repository.VisitRecordRepository;
import com.medicine.service.*;
import com.medicine.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;
    @Autowired
    private PatientService patientService;


    /**
     * 保存前端传过来的form对象
     * 看起来很复杂，其实思路很简单的，这里写个注释，方便自己或者收我工作的人看
     *
     * 因为前端传过来的数据很多，json分了很多成，这些数据再不同的表，用外键关联
     * 关联依据都在实体类中体现。
     *
     * 因为有很多数据，包装了很多层json，所以后台接收我也包了很多层
     * 这个方法要做的就是，把不同的数据，放到相应的实体类中去，然后保存
     * 因为用jpa 把关联关系都映射好了的，所以它会把相应的关系的表都添加了，所以
     * 只用保存父类，其它它自己完成
     * @param visitRecordForm
     * @return
     */
    @Override
    public VisitRecord save(VisitRecordForm visitRecordForm) {
        Date date = new Date();
        VisitRecord visitRecord = new VisitRecord();
        visitRecord.setCreateDate(date);
        /** 就诊次数 当前次数+1 **/
        Integer currentTime = visitRecordRepository.
                maxVisitTimes(visitRecordForm.getId());
        Integer time =  currentTime == null?1:currentTime+1;
        visitRecord.setVisitTimes(time);

        Patient patient = patientService.findById(visitRecordForm.getId());
        patient.setTime(time);
        /** 上一次就诊时间 **/
        patient.setEndDate(date);
        /** 首次就诊时间 **/
        if (time.equals(1)) {
            patient.setFirstDate(date);
        }

        /** 修改病人中的就诊时间 **/
        patientService.save(patient);

        visitRecord.setPatient(new Patient(visitRecordForm.getId()));
        /** 诊断治疗把from 数据转换成实体类 **/
        visitRecord.setDiagnosisAndtreatment(
                DiagnosisAndtreatmentFrom.dFromToD(
                        visitRecordForm.getDiagnosisAndtreatment()
                )
        );
        /** 把中医四诊 提交的from 转换成实体 以下都是， 但是jpa在嵌套第二次的时候
            需要把实体把父级添加到子集里面去 **/
        visitRecord.setDiagnosisOfZh(
                DiagnosisOfZhFrom.dZhFromToD(
                        visitRecordForm.getDiagnosisOfZh()
                )
        );
        /** 西医检查 **/
        visitRecord.setDiagnosisOfWe(
                DiagnosisOfWeFrom.dFromToD(
                        visitRecordForm.getDiagnosisOfWe()
                )
        );

        /** 其他 **/
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

    @Override
    public Page<YiAnReCodDTO> findByNameAndVisitDate(Pageable pageable, String name, String visitDate) {
        List<YiAnReCodDTO> yiAnReCodDTOS = new ArrayList<>();
        Page<Patient> patientPage = patientService.findAll(pageable, name, visitDate);
        List<Patient> patients = patientPage.getContent();
        if (patients.size() > 0) {
            patients.forEach(e ->{
                YiAnReCodDTO yiAnReCodDTO = new YiAnReCodDTO();
                List<VisitRecord> visitRecords = e.getVisitRecords();
                VisitRecord visitRecord = null;
                if (visitRecords.size() > 0) {
                    for (VisitRecord record:visitRecords) {
                       if (record.getStatus()!=null && record.getStatus().equals(1)) {
                           visitRecord = record;
                           break;
                       }
                    }
                }
                if (visitRecord != null) {
                    BeanUtils.copyProperties(e, yiAnReCodDTO);
                    yiAnReCodDTOS.add(yiAnReCodDTO);
                }

            });
        }
        return new PageImpl(yiAnReCodDTOS, pageable, patientPage.getTotalElements());
    }


}
