package org.monjasa.projectclinica.model.mainuser;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Authority extends AuditableEntity<String, Long> {

    private String name;

    private String description;
}
