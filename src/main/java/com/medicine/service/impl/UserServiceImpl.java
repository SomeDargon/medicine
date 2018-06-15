package com.medicine.service.impl;

import com.medicine.domain.User;
import com.medicine.domain.mapper.UserMapper;
import com.medicine.domain.repository.UserRepository;
import com.medicine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public int countByAccount(String account) {
        return userMapper.countByAccount(account);
    }
}
