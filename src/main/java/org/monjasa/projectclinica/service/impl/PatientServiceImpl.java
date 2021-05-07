package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.PatientMedicalRecord;
import org.monjasa.projectclinica.repository.PatientRepository;
import org.monjasa.projectclinica.service.PatientService;
import org.monjasa.projectclinica.util.mapper.PatientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    @Override
    public Page<PatientMedicalRecord> getAllPatientMedicalRecords(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map(patientMapper::toMedicalRecordTableRowDto);
    }
}
