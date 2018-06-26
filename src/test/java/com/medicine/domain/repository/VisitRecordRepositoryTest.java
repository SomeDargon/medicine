package com.medicine.domain.repository;

import com.medicine.domain.VisitRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VisitRecordRepositoryTest {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    @Test
    public void findByPatientId() {
        List<VisitRecord> visitRecords = visitRecordRepository.findByPatientId(1L);
        System.out.println(visitRecords);
    }
}