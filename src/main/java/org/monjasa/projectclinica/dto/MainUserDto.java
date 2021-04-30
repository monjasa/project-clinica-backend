package org.monjasa.projectclinica.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainUserDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private Integer age;
}
