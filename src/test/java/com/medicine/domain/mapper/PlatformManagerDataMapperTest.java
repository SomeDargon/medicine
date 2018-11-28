package com.medicine.domain.mapper;

import com.medicine.domain.dto.count.CountDTO;
import com.medicine.domain.dto.count.StatementDTO;
import com.medicine.domain.dtoAndFrom.menu.ZyManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.queryFrom.FJQueryFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlatformManagerDataMapperTest {

    @Autowired
    private PlatformManagerDataMapper platformManagerDataMapper;
    public void findByFj() {
        FJQueryFrom f = new FJQueryFrom();
        platformManagerDataMapper.findByFj(f);
    }

    @Test
    public void findCount() {
        FJQueryFrom f = new FJQueryFrom();
        List<CountDTO> statementDTOList = platformManagerDataMapper.selectCountZY(f);
        Map<String, Integer> map = new HashMap<>();
        statementDTOList.forEach(e -> {
            List<String> list = CountDTO.stringListConvertString(e.getSq());
            list.forEach(a -> {
                if(!map.containsKey(a)){
                    map.put(a, 1);
                }else {
                    map.put(a, map.get(a)+1);
                }
            });
        });
        List<StatementDTO> statementDTOS = new ArrayList<>();
        for (String in : map.keySet()) {
            StatementDTO statementDTO = new StatementDTO();
            statementDTO.setName(in);
            statementDTO.setCount(map.get(in));
            statementDTOS.add(statementDTO);
            System.out.println(statementDTO.getName()+":"+statementDTO.getCount());
        }

    }

    public void test() {
        FJQueryFrom f = new FJQueryFrom();
        List<StatementDTO> statementDTOList = platformManagerDataMapper.MedicineQuery(f);
        statementDTOList.forEach(e -> System.out.println(e.getName()+":"+e.getCount()));
    }
}