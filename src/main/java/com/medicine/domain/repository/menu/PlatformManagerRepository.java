package com.medicine.domain.repository.menu;


import com.medicine.domain.menu.PlatformManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformManagerRepository extends JpaRepository<PlatformManager, Long> {

    List<PlatformManager> findByMenuType(String menuType);
}
