package com.medicine.domain.repository;

import com.medicine.domain.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void findByUserNameLike() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Patient> patients = patientRepository.findByNameLike("1", pageable);
        patients.forEach(e -> System.out.println(e.getId()));
    }
}