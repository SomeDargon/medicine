package com.medicine.domain.repository.menu;


import com.medicine.domain.menu.PlatformManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformManagerRepository extends JpaRepository<PlatformManager, Long> {

    List<PlatformManager> findBySysType(String sysType);

    List<PlatformManager> findByIsMenuAndSysType(Integer isMenu, String sysType);

    List<PlatformManager> findByFClass(Long fClass);
}
