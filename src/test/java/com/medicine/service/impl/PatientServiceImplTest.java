package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientServiceImplTest {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void test() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Patient> patients =  patientRepository.findAll(pageable);
        System.out.println(patients);
    }

}