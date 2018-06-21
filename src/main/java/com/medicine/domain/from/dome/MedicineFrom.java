package com.medicine.domain.from.dome;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "处方详情")
public class MedicineFrom {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String liang;

    @ApiModelProperty(value = "剂数")
    private String zhuyong;

    @ApiModelProperty(value = "医师")
    private String yongfa;
}
