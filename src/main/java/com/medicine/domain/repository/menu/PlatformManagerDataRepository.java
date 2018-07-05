package com.medicine.domain.repository.menu;

import com.medicine.domain.menu.PlatformManagerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformManagerDataRepository extends JpaRepository<PlatformManagerData, Long>{

    PlatformManagerData findByPmId(Long id);


}
