package org.monjasa.projectclinica.model.patient;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class BloodType extends AuditableEntity<String, Long> {

    private String name;
}
