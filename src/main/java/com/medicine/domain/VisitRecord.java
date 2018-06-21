package com.medicine.domain;

import com.medicine.domain.attiendRecode.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class VisitRecord extends BaseEntity {

    private Date createDate;

    private Date visitTime;

    // 诊断治疗
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_treatment_id")
    private DiagnosisAndtreatment diagnosisAndtreatment;

    // 中医四诊
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_zh_id")
    private DiagnosisOfZh diagnosisOfZh;

    // 西医检查
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_we_id")
    private DiagnosisOfWe diagnosisOfWe;

    // 其他
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_id")
    private OtherMessage otherMessage;

    // 处方详情
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
}
