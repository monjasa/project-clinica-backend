package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.NamedIdentificationDto;
import org.monjasa.projectclinica.dto.patient.PatientDetailedInfoDto;
import org.monjasa.projectclinica.dto.patient.PatientMedicalRecordShortInfoDto;
import org.monjasa.projectclinica.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/medical-records")
    @PreAuthorize("hasAuthority('DEFAULT_AUTHORITY')")
    public Page<PatientMedicalRecordShortInfoDto> getPatientMedicalRecords(Pageable pageable) {
        return patientService.getAllPatientMedicalRecords(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('DEFAULT_AUTHORITY')")
    public PatientDetailedInfoDto getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/names")
    @PreAuthorize("hasAuthority('DEFAULT_AUTHORITY')")
    public List<NamedIdentificationDto> getPatientNames() {
        return patientService.getAllPatientNames();
    }
}
