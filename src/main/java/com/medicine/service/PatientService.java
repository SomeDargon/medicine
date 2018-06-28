package com.medicine.service;

import com.medicine.domain.Patient;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import org.springframework.data.domain.Page;

public interface PatientService {

    Page<PatientDTO> findPatientCriteria(Integer page, Integer size, String name);

    Patient save(PatientFrom patientFrom);

    Patient findById(Long id);

    Patient save(Patient patient);
}
