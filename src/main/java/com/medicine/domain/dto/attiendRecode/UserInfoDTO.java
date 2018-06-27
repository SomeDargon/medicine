package com.medicine.domain.dto.attiendRecode;

import com.medicine.domain.Patient;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel("患者信息")
@Data
public class UserInfoDTO {

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

    private Date visitTime;

    // 邮编
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

    // TODO
    private Integer age = 10;

    public static UserInfoDTO patientToUserInfo(Patient patient) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(patient, userInfoDTO);
        return userInfoDTO;
    }
}
