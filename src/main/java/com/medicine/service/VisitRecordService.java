package com.medicine.service;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.from.VisitRecordForm;

public interface VisitRecordService {

    VisitRecord save(VisitRecordForm visitRecordForm);
}
