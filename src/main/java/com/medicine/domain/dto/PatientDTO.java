package com.medicine.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.util.Date2LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value = "病人列表字段")
public class PatientDTO {

    private Long id;

    private String name;

    private String sex;

    private String phone;

    private String address;

    private Integer age;

    private Integer time;

    private String birthplace;

    private String zipCode;

    private Integer marriage;

    private String citizenship;

    private String profession;

    private String ethnic;

    private Double weight;

    @ApiModelProperty(name = "首次就诊时间")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date date;

    @ApiModelProperty(name = "上一次就诊时间")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date endDate;

}
