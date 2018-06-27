package com.medicine.domain.dto;

import com.medicine.domain.attiendRecode.DiagnosisAndtreatment;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.DiagnosisAndtreatmentDTO;
import com.medicine.domain.dto.attiendRecode.orther.OrtherDTO;
import lombok.Data;

import java.util.Date;

@Data
public class VisitRecordDTO {

    private Long id;

    private Date date;

    private Integer visitTimes;

    private DiagnosisOfZhDTO diagnosisOfZh;

    private DiagnosisOfWeDTO diagnosisOfWe;

    private DiagnosisAndtreatmentDTO diagnosisAndtreatment;

    private OrtherDTO orther;


}
