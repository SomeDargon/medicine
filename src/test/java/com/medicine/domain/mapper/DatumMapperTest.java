package com.medicine.domain.mapper;

import com.medicine.domain.dto.DatumDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatumMapperTest {

    @Autowired
    private DatumMapper datumMapper;

    @Test
    public void test() {
        List<DatumDTO> datumDTOS = datumMapper.findByList("q", "q");
        System.out.println(datumDTOS.size());
    }

}