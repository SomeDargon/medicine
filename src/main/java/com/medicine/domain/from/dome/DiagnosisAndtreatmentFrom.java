package com.medicine.domain.from.dome;

import com.medicine.domain.attiendRecode.DiagnosisAndtreatment;
import com.medicine.domain.attiendRecode.Medicine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@ApiModel(value = "诊断治疗")
public class DiagnosisAndtreatmentFrom {

    @ApiModelProperty(value = "中医疾病")
    private String zyjb;

    @ApiModelProperty(value = "西医疾病")
    private String xyjb;

    @ApiModelProperty(value = "中医证候")
    private String zyzh;

    @ApiModelProperty(value = "治则治法")
    private String zzzf;

    @ApiModelProperty(value = "名称")
    private String zfm;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "剂数")
    private String number;

    @ApiModelProperty(value = "医师")
    private String doctor;

    @ApiModelProperty(value = "中成药")
    private String medicineC;

    @ApiModelProperty(value = "西成药")
    private String medicineW;

    @ApiModelProperty(value = "其他")
    private String orther;

    @ApiModelProperty(value = "处方详情")
    private List<MedicineFrom> medicine;


    public static DiagnosisAndtreatment
    dFromToD(DiagnosisAndtreatmentFrom diagnosisAndtreatmentFrom) {
       DiagnosisAndtreatment diagnosisAndtreatment =
                                new DiagnosisAndtreatment();
       BeanUtils.copyProperties(diagnosisAndtreatmentFrom, diagnosisAndtreatment);
       diagnosisAndtreatment.setMedicine(
               MedicineFrom.medicineFormTomedicine(
                       diagnosisAndtreatmentFrom.getMedicine(),
                       diagnosisAndtreatment
               )
       );
       diagnosisAndtreatment.setOther(diagnosisAndtreatmentFrom.getOrther());
       return diagnosisAndtreatment;
    }

}
