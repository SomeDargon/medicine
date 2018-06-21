package com.medicine.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 病人
 */
@Data
@Entity
public class Patient extends BaseEntity {

    private Long cardId;

    private String name;

    private String sex;

    private String phone;

    // 所在城市
    private String city;

    // 所在省
    private String country;

    // 所在区
    private String province;

    // 出生地
    private String birthplace;

    @Column(name = "visit_time")
    private Date visitTime;

    // 邮编
    @Column(name = "zip_code")
    private String zipCode;

    // 婚姻 （1已婚 0未婚 3其他）
    private Integer marriage;

    // 国际
    private String citizenship;

    // 职业
    private String profession;

    // 民族
    private String ethnic;

    // 体重
    private Double weight;

    // 身高
    private Double height;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
