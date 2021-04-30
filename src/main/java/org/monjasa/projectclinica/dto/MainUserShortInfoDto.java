package org.monjasa.projectclinica.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainUserShortInfoDto {

    private Long id;

    private String fullName;

    private String gender;

    private String email;

    private String phoneNumber;
}
