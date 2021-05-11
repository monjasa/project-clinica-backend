package org.monjasa.projectclinica.service;

import org.monjasa.projectclinica.dto.patient.PatientDetailedInfoDto;
import org.monjasa.projectclinica.dto.patient.PatientMedicalRecordShortInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {

    Page<PatientMedicalRecordShortInfoDto> getAllPatientMedicalRecords(Pageable pageable);

    PatientDetailedInfoDto getPatientById(Long id);
}
