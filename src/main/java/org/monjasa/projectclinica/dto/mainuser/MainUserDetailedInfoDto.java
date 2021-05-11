package org.monjasa.projectclinica.dto.mainuser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainUserDetailedInfoDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String dateOfBirth;

    private String gender;

    private String pictureUrl;
}
