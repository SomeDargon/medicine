package com.medicine.domain.repository.attiendRecode;

import com.medicine.domain.attiendRecode.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
