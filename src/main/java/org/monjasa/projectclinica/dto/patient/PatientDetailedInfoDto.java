package org.monjasa.projectclinica.dto.patient;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.dto.mainuser.MainUserDetailedInfoDto;

@Getter
@Setter
public class PatientDetailedInfoDto {

    private Long id;

    private MainUserDetailedInfoDto user;

    private String occupation;

    private String insuranceNumber;

    private MedicalRecordDetailedInfoDto medicalRecord;
}
