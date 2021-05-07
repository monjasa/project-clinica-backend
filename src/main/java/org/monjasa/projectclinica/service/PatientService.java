package org.monjasa.projectclinica.service;

import org.monjasa.projectclinica.dto.PatientMedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {

    Page<PatientMedicalRecord> getAllPatientMedicalRecords(Pageable pageable);
}
