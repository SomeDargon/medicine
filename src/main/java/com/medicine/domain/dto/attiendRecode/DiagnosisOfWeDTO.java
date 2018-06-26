package com.medicine.domain.dto.attiendRecode;

import com.medicine.domain.attiendRecode.WesternMedicine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("西医")
public class DiagnosisOfWeDTO {

    private String tigejiancha;

    @ApiModelProperty(value = "血常规")
    private WesternMedicine xcg;

    @ApiModelProperty(value = "心电图")
    private WesternMedicine xdt;

    @ApiModelProperty(value = "尿常规")
    private WesternMedicine ncg;

    @ApiModelProperty(value = "CT")
    private WesternMedicine ct;

    @ApiModelProperty(value = "大便常规")
    private WesternMedicine dbcg;

    @ApiModelProperty(value = "MRI")
    private WesternMedicine mri;

    @ApiModelProperty(value = "血生化")
    private WesternMedicine xsh;

    @ApiModelProperty(value = "超声")
    private WesternMedicine cs;

    @ApiModelProperty(value = "X光")
    private WesternMedicine x;

    @ApiModelProperty(value = "其他")
    private WesternMedicine orther;
}
