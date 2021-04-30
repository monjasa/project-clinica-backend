package org.monjasa.projectclinica.model;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MainUser extends AuditableEntity<String, Long> {

    private String firstName;

    private String lastName;

    private String genderIso;

    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    private String phoneNumber;
}
