package com.medicine.service.impl;

import com.medicine.domain.mapper.PlatformManagerDataMapper;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.queryFrom.ZyQueryFrom;
import com.medicine.service.PlatformManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformManagerServiceImplTest {

    @Autowired
    private PlatformManagerDataMapper platformManagerDataMapper;

    @Test
    public void findZhongYi() {
        PageRequest pageRequest = PageRequest.of(1-1, 10);
        ZyQueryFrom zyQueryFrom = new ZyQueryFrom();
        zyQueryFrom.setGlzz("'%%'");
        zyQueryFrom.setJy("'%3%'");
        zyQueryFrom.setName("%中药%");
        zyQueryFrom.setXwgj("%热%");
        zyQueryFrom.setXz("'%3%'");
        zyQueryFrom.setType(0);
        List<PlatformManagerData> platformManagerData = platformManagerDataMapper.selectPlatformManagerDataList(zyQueryFrom);
        System.out.println(platformManagerData);
    }
}