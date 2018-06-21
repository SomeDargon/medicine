package com.medicine.domain.from.dome;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "西医检查")
public class DiagnosisOfWeFrom {

    @ApiModelProperty(value = "体格检查")
    private String tigejiancha;

    @ApiModelProperty(value = "血常规")
    private WesternMedicineFrom xcg;

    @ApiModelProperty(value = "心电图")
    private WesternMedicineFrom xdt;

    @ApiModelProperty(value = "尿常规")
    private WesternMedicineFrom ncg;

    @ApiModelProperty(value = "CT")
    private WesternMedicineFrom CT;

    @ApiModelProperty(value = "大便常规")
    private WesternMedicineFrom dbcg;

    @ApiModelProperty(value = "MRI")
    private WesternMedicineFrom MRI;

    @ApiModelProperty(value = "血生化")
    private WesternMedicineFrom xsh;

    @ApiModelProperty(value = "超声")
    private WesternMedicineFrom cs;

    @ApiModelProperty(value = "X光")
    private WesternMedicineFrom X;

    @ApiModelProperty(value = "其他")
    private WesternMedicineFrom orther;
}
