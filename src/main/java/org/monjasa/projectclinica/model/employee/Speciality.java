package org.monjasa.projectclinica.model.employee;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Speciality extends AuditableEntity<String, Long> {

    private String name;
}
