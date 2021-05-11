package org.monjasa.projectclinica.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecordDetailedInfoDto {

    private Long id;

    private Double height;

    private Double weight;

    private String bloodType;
}
