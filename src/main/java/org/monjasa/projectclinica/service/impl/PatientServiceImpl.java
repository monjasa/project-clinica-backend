package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.dto.patient.PatientDetailedInfoDto;
import org.monjasa.projectclinica.dto.patient.PatientMedicalRecordShortInfoDto;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.repository.PatientRepository;
import org.monjasa.projectclinica.service.PatientService;
import org.monjasa.projectclinica.util.mapper.PatientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    @Override
    public Page<PatientMedicalRecordShortInfoDto> getAllPatientMedicalRecords(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map(patientMapper::toMedicalRecordTableRowDto);
    }

    @Override
    public PatientDetailedInfoDto getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patientMapper::toDetailedInfoDto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NamedIdentificationDto> getAllPatientNames() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toNamedIdentificationDto)
                .collect(Collectors.toList());
    }
}
