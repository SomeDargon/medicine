package com.medicine.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.util.Date2LongSerializer;
import lombok.Data;

import java.util.Date;


@Data
public class PatientDTO {

    private Long id;

    private String name;

    private String sex;

    private String phone;

    private String address;

    private Integer age;

    private Integer time;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date date;
}
