package org.monjasa.projectclinica.model.mainuser;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.enumeration.Gender;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

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

    private String pictureUrl;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "main_user_authority",
            joinColumns = @JoinColumn(name = "main_user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;
}
