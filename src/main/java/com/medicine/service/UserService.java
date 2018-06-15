package com.medicine.service;

import com.medicine.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int countByAccount(String account);
}
