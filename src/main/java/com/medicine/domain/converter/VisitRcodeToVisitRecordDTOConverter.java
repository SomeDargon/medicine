package com.medicine.domain.converter;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.attiendRecode.*;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.*;
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

        WesternMedicineDTO westernMedicineDTO = new WesternMedicineDTO();

        BeanUtils.copyProperties(diagnosisOfZh, wqDTO);
        BeanUtils.copyProperties(diagnosisOfZh, zhaiyaoDTO);
        BeanUtils.copyProperties(diagnosisOfZh, askDTO);
        BeanUtils.copyProperties(diagnosisOfZh, lookDTO);

        BeanUtils.copyProperties(diagnosisOfZh.getWesternMedicine(), westernMedicineDTO);
        List<String> images = new ArrayList<>();
        diagnosisOfZh.getWesternMedicine().getImg().forEach(
                img -> images.add(img.getUrl())
        );
        westernMedicineDTO.setImg(images);
        lookDTO.setShezhenimg(westernMedicineDTO);
        diagnosisOfZhDTO.setAsk(askDTO);
        diagnosisOfZhDTO.setLook(lookDTO);
        diagnosisOfZhDTO.setZhaiyao(zhaiyaoDTO);
        diagnosisOfZhDTO.setWq(wqDTO);

        visitRecordDTO.setDiagnosisOfZh(diagnosisOfZhDTO);

        // 西医检查
        DiagnosisOfWeDTO diagnosisOfWeDTO = new DiagnosisOfWeDTO();
        DiagnosisOfWe diagnosisOfWe = visitRecord.getDiagnosisOfWe();
        List<WesternMedicine> westernMedicines = diagnosisOfWe.getWesternMedicines();
        westernMedicines.forEach(westernMedicine -> {
            WesternMedicineDTO e = new WesternMedicineDTO();
            BeanUtils.copyProperties(westernMedicine, e);
            List<String> list = new ArrayList<>();
            westernMedicine.getImg().forEach(
                    img -> list.add(img.getUrl())
            );
            e.setImg(list);
            switch (westernMedicine.getName()) {
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
        OtherDTO otherDTO = new OtherDTO();

        BeanUtils.copyProperties(diagnosisAndtreatment, zdyzlDTO);
        BeanUtils.copyProperties(diagnosisAndtreatment, zycfDTO);
        BeanUtils.copyProperties(diagnosisAndtreatment, otherDTO);
        otherDTO.setOrther(diagnosisAndtreatment.getOther());
        cfDTO.setOrther(otherDTO);

        zycfDTO.setMedicine(MedicineToMedicineDTO.converter(diagnosisAndtreatment.getMedicine()));
        cfDTO.setZycf(zycfDTO);

        diagnosisAndtreatmentDTO.setCf(cfDTO);
        diagnosisAndtreatmentDTO.setZdyzl(zdyzlDTO);

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
        visitRecordDTO.setOrther(ortherDTO);
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
