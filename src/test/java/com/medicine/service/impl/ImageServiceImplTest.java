package com.medicine.service.impl;

import com.medicine.service.ImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageServiceImplTest {

    @Autowired
    ImageService imageService;

    @Test
    public void deleteById() {
        imageService.deleteByWesternMedicineId(493L);
    }
}