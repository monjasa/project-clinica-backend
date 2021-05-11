package org.monjasa.projectclinica.model.clinic;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Address extends AuditableEntity<String, Long> {

    private String country;

    private String nameLine;

    private String firstName;

    private String lastName;

    private String organisationName;

    private String administrativeArea;

    private String subAdministrativeArea;

    private String locality;

    private String dependentLocality;

    private String postalCode;

    private String thoroughfare;

    private String premise;

    private String subPremise;
}
