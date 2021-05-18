package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.service.MedicalEmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medical-employees")
@RequiredArgsConstructor
public class MedicalEmployeeController {

    private final MedicalEmployeeService medicalEmployeeService;

    @GetMapping("/names")
    @PreAuthorize("hasAuthority('DEFAULT_AUTHORITY')")
    public List<NamedIdentificationDto> getMedicalEmployeeNames() {
        return medicalEmployeeService.getAllMedicalEmployeeNames();
    }
}
