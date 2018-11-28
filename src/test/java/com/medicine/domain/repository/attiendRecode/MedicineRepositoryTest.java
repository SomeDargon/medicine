package com.medicine.domain.repository.attiendRecode;

import com.medicine.domain.attiendRecode.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineRepositoryTest {

    @Autowired
    private MedicineRepository medicineRepository;
    @Test
    public void deleteByDatId() {

        List<Medicine> list = medicineRepository.findByDatId(58L);
        System.out.println(list.size());
    }
}