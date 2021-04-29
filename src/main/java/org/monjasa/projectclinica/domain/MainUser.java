package org.monjasa.projectclinica.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class MainUser extends AbstractAuditable<MainUser, Long> {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Integer age;
}
