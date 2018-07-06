package com.medicine.service;

import com.medicine.domain.menu.PlatformManager;

import java.util.List;
import java.util.Map;

public interface PlatformManagerService {
    PlatformManager save(Map<String, Object> data);

    List<Map<String, Object>> findByManager(String type);

    void deletePlatAndPlatDate(Long id);

    List<String> findByZyName();
}
