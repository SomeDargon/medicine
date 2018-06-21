package com.medicine.service.impl;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.repository.VisitRecordRepository;
import com.medicine.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    @Override
    public VisitRecord save(VisitRecordForm visitRecordForm) {
        return null;
    }
}
