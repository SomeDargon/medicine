package com.medicine.domain.from.dome;

import com.medicine.domain.attiendRecode.DiagnosisOfWe;
import com.medicine.domain.attiendRecode.WesternMedicine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "西医检查")
public class DiagnosisOfWeFrom {

    @ApiModelProperty(value = "体格检查")
    private String tigejiancha;

    @ApiModelProperty(value = "所有检查报告")
    private List<WesternMedicine> westernMedicines;


    public static DiagnosisOfWe dFromToD(DiagnosisOfWeFrom diagnosisOfWeFrom) {
        DiagnosisOfWe diagnosisOfWe = new DiagnosisOfWe();
        diagnosisOfWe.setTigejiancha(diagnosisOfWeFrom.getTigejiancha());
        List<WesternMedicine> westernMedicines = diagnosisOfWeFrom.getWesternMedicines();
        /** 多级关联需要把父级编号 放在子级中去 **/
        westernMedicines.forEach(e -> {
            e.setDOfWe(diagnosisOfWe);
            if (e.getImg() != null) {
                e.getImg().forEach(image -> image.setWestern(e));
            }
        });
        diagnosisOfWe.setWesternMedicines(westernMedicines);
        return diagnosisOfWe;
    }

}
