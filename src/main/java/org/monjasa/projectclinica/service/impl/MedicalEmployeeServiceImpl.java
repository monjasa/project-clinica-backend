package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.repository.MedicalEmployeeRepository;
import org.monjasa.projectclinica.service.MedicalEmployeeService;
import org.monjasa.projectclinica.util.mapper.MedicalEmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalEmployeeServiceImpl implements MedicalEmployeeService {

    private final MedicalEmployeeRepository medicalEmployeeRepository;

    private final MedicalEmployeeMapper medicalEmployeeMapper;

    @Override
    public List<NamedIdentificationDto> getAllMedicalEmployeeNames() {
        return medicalEmployeeRepository.findAll()
                .stream()
                .map(medicalEmployeeMapper::toNamedIdentificationDto)
                .collect(Collectors.toList());
    }
}
