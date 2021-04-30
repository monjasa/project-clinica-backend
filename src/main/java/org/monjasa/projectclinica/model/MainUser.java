package org.monjasa.projectclinica.model;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.enumeration.Gender;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "main_user_id_seq", allocationSize = 1)
public class MainUser extends AuditableEntity<String, Long> {

    private String firstName;

    private String lastName;

    private Gender genderIso;

    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    private String phoneNumber;
}
