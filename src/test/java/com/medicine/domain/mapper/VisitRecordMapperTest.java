package com.medicine.domain.mapper;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.YanQueryFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VisitRecordMapperTest {

    @Autowired
    private VisitRecordMapper visitRecordMapper;

    @Test
    public void test() {
        FJQueryFrom y = new FJQueryFrom();

//        List<VisitRecord> visitRecords = visitRecordMapper.findByFj(y);
//        System.out.println(visitRecords.size());
    }
}