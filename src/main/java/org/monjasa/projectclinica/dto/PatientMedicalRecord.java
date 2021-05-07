package org.monjasa.projectclinica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientMedicalRecord {

    private Long id;

    private String firstName;

    private String lastName;

    private String insuranceNumber;

    private Double height;

    private Double weight;

    private String bloodType;
}
