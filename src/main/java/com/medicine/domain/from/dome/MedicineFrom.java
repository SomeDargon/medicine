package com.medicine.domain.from.dome;

import com.medicine.domain.attiendRecode.DiagnosisAndtreatment;
import com.medicine.domain.attiendRecode.Medicine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static Medicine medicineFormTomedicine(
            MedicineFrom medicineFrom, DiagnosisAndtreatment diagnosisAndtreatment
    ) {
        Medicine medicine = new Medicine();
        BeanUtils.copyProperties(medicineFrom, medicine);
        medicine.setDat(diagnosisAndtreatment);
        return medicine;
    }

    public static List<Medicine> medicineFormTomedicine(
            List<MedicineFrom> medicineFromList,
            DiagnosisAndtreatment diagnosisAndtreatment
    ) {
        List<Medicine> medicines = new ArrayList<>();
        medicineFromList.forEach(e ->
                medicines.add(medicineFormTomedicine(e, diagnosisAndtreatment))
        );
        return medicines;
    }
}
