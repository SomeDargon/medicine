package com.medicine.domain.dto;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientRecodDTO {

    private List<VisitRecordDTO> data;

    private UserInfoDTO infoDTO;
}
