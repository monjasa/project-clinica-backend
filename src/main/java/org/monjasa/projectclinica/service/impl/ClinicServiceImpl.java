package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.repository.ClinicRepository;
import org.monjasa.projectclinica.service.ClinicService;
import org.monjasa.projectclinica.util.mapper.ClinicMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;

    private final ClinicMapper clinicMapper;

    @Override
    public List<NamedIdentificationDto> getAllClinicNames() {
        return clinicRepository.findAll()
                .stream()
                .map(clinicMapper::toNamedIdentificationDto)
                .collect(Collectors.toList());
    }
}
