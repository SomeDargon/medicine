package com.medicine.domain.dto;

import lombok.Data;


@Data
public class PatientDTO {

    private Long id;

    private String name;

    private String sex;

    private String phone;

    private String address;

    private Integer age;

    private Integer time;
}
