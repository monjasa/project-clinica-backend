package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.PatientMedicalRecord;
import org.monjasa.projectclinica.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/medical-records")
    @PreAuthorize("hasAuthority('DEFAULT_AUTHORITY')")
    public Page<PatientMedicalRecord> getPatientMedicalRecords(Pageable pageable) {
        return patientService.getAllPatientMedicalRecords(pageable);
    }
}
