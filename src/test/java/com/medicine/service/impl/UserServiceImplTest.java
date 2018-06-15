package com.medicine.service.impl;

import com.medicine.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    public void findAll() {
        userService.findAll();
    }

    @Test
    public void countByAccount() {
        userService.countByAccount("xiaolong");
    }
}