package com.medicine.domain.converter;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.attiendRecode.*;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.CfDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.DiagnosisAndtreatmentDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.ZdyzlDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.ZycfDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.AskDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.LookDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.WqDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.ZhaiyaoDTO;
import com.medicine.domain.dto.attiendRecode.orther.AnyuDTO;
import com.medicine.domain.dto.attiendRecode.orther.HuifangjiluDTO;
import com.medicine.domain.dto.attiendRecode.orther.OrtherDTO;
import com.medicine.domain.dto.attiendRecode.orther.ZhiliaoxiaoguoDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class VisitRcodeToVisitRecordDTOConverter{

    public static VisitRecordDTO convert(VisitRecord visitRecord) {
        VisitRecordDTO visitRecordDTO = new VisitRecordDTO();
        BeanUtils.copyProperties(visitRecord, visitRecordDTO);
        // 中医四诊 这个是根据前端定的api
        DiagnosisOfZh diagnosisOfZh = visitRecord.getDiagnosisOfZh();
        DiagnosisOfZhDTO diagnosisOfZhDTO = new DiagnosisOfZhDTO();
        AskDTO askDTO = new AskDTO();
        LookDTO lookDTO = new LookDTO();
        WqDTO wqDTO = new WqDTO();
        ZhaiyaoDTO zhaiyaoDTO = new ZhaiyaoDTO();

        BeanUtils.copyProperties(diagnosisOfZh, wqDTO);
        BeanUtils.copyProperties(diagnosisOfZh, zhaiyaoDTO);
        BeanUtils.copyProperties(diagnosisOfZh, askDTO);
        BeanUtils.copyProperties(diagnosisOfZh, lookDTO);

        diagnosisOfZhDTO.setAsk(askDTO);
        diagnosisOfZhDTO.setLook(lookDTO);
        diagnosisOfZhDTO.setZhaiyao(zhaiyaoDTO);
        diagnosisOfZhDTO.setWq(wqDTO);
        diagnosisOfZhDTO.setShezhenimg(diagnosisOfZh.getWesternMedicine());

        visitRecordDTO.setDiagnosisOfZh(diagnosisOfZhDTO);

        // 西医检查
        DiagnosisOfWeDTO diagnosisOfWeDTO = new DiagnosisOfWeDTO();
        DiagnosisOfWe diagnosisOfWe = visitRecord.getDiagnosisOfWe();
        List<WesternMedicine> westernMedicines = diagnosisOfWe.getWesternMedicines();
        westernMedicines.forEach(e -> {
            switch (e.getName()) {
                case "xcg": diagnosisOfWeDTO.setXcg(e); break;
                case "xdt": diagnosisOfWeDTO.setXdt(e); break;
                case "ncg": diagnosisOfWeDTO.setNcg(e); break;
                case "ct": diagnosisOfWeDTO.setCt(e); break;
                case "dbcg": diagnosisOfWeDTO.setDbcg(e); break;
                case "mri": diagnosisOfWeDTO.setMri(e); break;
                case "xsh": diagnosisOfWeDTO.setXsh(e); break;
                case "cs": diagnosisOfWeDTO.setCs(e); break;
                case "x": diagnosisOfWeDTO.setX(e); break;
                case "orther": diagnosisOfWeDTO.setOrther(e); break;
            }
        });
        diagnosisOfWeDTO.setTigejiancha(diagnosisOfWe.getTigejiancha());
        visitRecordDTO.setDiagnosisOfWe(diagnosisOfWeDTO);

        // 诊断治疗
        DiagnosisAndtreatment diagnosisAndtreatment = visitRecord.getDiagnosisAndtreatment();
        DiagnosisAndtreatmentDTO diagnosisAndtreatmentDTO = new DiagnosisAndtreatmentDTO();
        ZdyzlDTO zdyzlDTO = new ZdyzlDTO();
        BeanUtils.copyProperties(diagnosisAndtreatment, zdyzlDTO);
        CfDTO cfDTO = new CfDTO();
        ZycfDTO zycfDTO = new ZycfDTO();
        BeanUtils.copyProperties(diagnosisAndtreatment, zdyzlDTO);
        BeanUtils.copyProperties(diagnosisAndtreatment, zycfDTO);
        cfDTO.setZycf(zycfDTO);
        diagnosisAndtreatmentDTO.setCf(cfDTO);
        diagnosisAndtreatmentDTO.setZdyz(zdyzlDTO);
        visitRecordDTO.setDiagnosisAndtreatment(diagnosisAndtreatmentDTO);
        // 其他
        OtherMessage otherMessage = visitRecord.getOtherMessage();
        OrtherDTO ortherDTO = new OrtherDTO();
        HuifangjiluDTO huifangjiluDTO = new HuifangjiluDTO();
        AnyuDTO anyuDTO = new AnyuDTO();
        ZhiliaoxiaoguoDTO zhiliaoxiaoguoDTO = new ZhiliaoxiaoguoDTO();
        BeanUtils.copyProperties(otherMessage, huifangjiluDTO);
        BeanUtils.copyProperties(otherMessage, anyuDTO);
        BeanUtils.copyProperties(otherMessage, zhiliaoxiaoguoDTO);
        ortherDTO.setAnyu(anyuDTO);
        ortherDTO.setHuifangjilu(huifangjiluDTO);
        ortherDTO.setZhiliaoxiaoguo(zhiliaoxiaoguoDTO);
        visitRecordDTO.setOrtherDTO(ortherDTO);
        return visitRecordDTO;
    }

    public static List<VisitRecordDTO> convert(List<VisitRecord> visitRecords) {
        List<VisitRecordDTO> visitRecordDTOS = new ArrayList<>();
        visitRecords.forEach(
                visitRecord -> visitRecordDTOS.add(
                        convert(visitRecord)
                )
        );
        return visitRecordDTOS;
    }
}
