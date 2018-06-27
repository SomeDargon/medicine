package com.medicine.domain.dto;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.attiendRecode.DataDTO;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientRecodDTO {

    private DataDTO historyData;

    private UserInfoDTO info;
}
