package com.medicine.domain.converter;

import com.medicine.domain.Patient;
import com.medicine.domain.dto.PatientDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientToPatientDTOConverter{

    public static PatientDTO converter(Patient Patient) {
       PatientDTO PatientDTO = new PatientDTO();
       BeanUtils.copyProperties(Patient, PatientDTO);
       return  PatientDTO;
    }

    public static List<PatientDTO> converter(List<Patient> Patients) {
        List<PatientDTO> PatientDTOS = new ArrayList<>();
        Patients.forEach(Patient -> PatientDTOS.add(converter(Patient)));
        return PatientDTOS;
    }
}
