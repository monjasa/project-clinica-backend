package org.monjasa.projectclinica.service;

import org.monjasa.projectclinica.dto.NamedIdentificationDto;

import java.util.List;

public interface ClinicService {
    List<NamedIdentificationDto> getAllClinicNames();
}
