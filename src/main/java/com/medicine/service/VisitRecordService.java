package com.medicine.service;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.from.VisitRecordForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface VisitRecordService {

    VisitRecord save(VisitRecordForm visitRecordForm);

    PatientRecodDTO findById(Long id);

    Page<YiAnReCodDTO> findByNameAndVisitDate(Pageable pageable, String name, Date visitDate);
}
