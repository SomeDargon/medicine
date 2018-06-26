package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * 处方详情
 */
@Data
@Entity
public class Medicine extends BaseEntity {

    // 名称
    private String name;

    // 类型
    private String liang;

    // 剂数
    private String zhuyong;

    // 医师
    private String yongfa;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "dat_id")
    private DiagnosisAndtreatment dat;
}
