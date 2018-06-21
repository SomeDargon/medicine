package com.medicine.domain.repository;

import com.medicine.domain.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
}
