package org.monjasa.projectclinica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainUserShortInfoDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String dateOfBirth;

    private String gender;

    private String pictureUrl;
}
