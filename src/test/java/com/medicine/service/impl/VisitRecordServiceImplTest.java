package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.DiagnosisOfWe;
import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.attiendRecode.Medicine;
import com.medicine.domain.attiendRecode.WesternMedicine;
import com.medicine.service.DiagnosisOfWeService;
import com.medicine.service.ImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VisitRecordServiceImplTest {

    @Autowired
    private DiagnosisOfWeService diagnosisOfWeService;

    @Autowired
    private ImageService imageService;
    @Test
    public void save() {
        DiagnosisOfWe diagnosisOfWe = new DiagnosisOfWe();
        diagnosisOfWe.setTigejiancha("xxx");
        List<WesternMedicine> medicines = new ArrayList<>();
        WesternMedicine medicine = new WesternMedicine();
        medicine.setName("xax");
        medicine.setText("xax");
        List<Image> images = new ArrayList<>();
        Image image = new Image();
        image.setName("xax");
        image.setUrl("xxax");
        image.setWestern(medicine);
        images.add(image);
        medicine.setImg(images);

        medicines.add(medicine);
        diagnosisOfWe.setWesternMedicines(medicines);
        diagnosisOfWeService.save(diagnosisOfWe);
    }
}