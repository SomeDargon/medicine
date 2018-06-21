package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.converter.PatientToPatientDTOConverter;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import com.medicine.domain.repository.PatientRepository;
import com.medicine.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Page<PatientDTO> findPatientCriteria(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Patient> patients = patientRepository.findAll(pageable);
        List<PatientDTO> PatientDTOS =
                PatientToPatientDTOConverter.converter(patients.getContent());

        return new PageImpl<>(PatientDTOS, pageable, patients.getTotalElements());
    }

    @Override
    public Patient save(PatientFrom patientFrom) {
        return patientRepository.save(
                patientFrom.patientFormToPatient(patientFrom)
        );
    }
}
