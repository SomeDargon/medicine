package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.converter.PatientToPatientDTOConverter;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import com.medicine.domain.repository.PatientRepository;
import com.medicine.service.PatientService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Page<PatientDTO> findPatientCriteria(Pageable pageable, String name) {
        Page<Patient> patients = StringUtils.isEmpty(name)?
                patientRepository.findAll(pageable):patientRepository.findByNameLike(name, pageable);
        List<PatientDTO> PatientDTOS =
                PatientToPatientDTOConverter.converter(patients.getContent());

        return new PageImpl<>(PatientDTOS, pageable, patients.getTotalElements());
    }

    @Override
    public Patient save(PatientFrom patientFrom) {
        return save(PatientFrom.patientFormToPatient(patientFrom));
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.getOne(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findByPhone(String phone) {
        return patientRepository.findByPhone(phone);
    }

    @Override
    public Page<Patient> findAll(Pageable pageable, String name, Date visitDate) {
        Patient patient = new Patient();
        patient.setVisitTime(visitDate);
        patient.setName(name);
        Example<Patient> example = Example.of(patient);
        Page<Patient> patients = patientRepository.findAll(example, pageable);
        return patients;
    }


}
