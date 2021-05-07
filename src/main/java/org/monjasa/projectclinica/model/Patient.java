package org.monjasa.projectclinica.model;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Patient extends AuditableEntity<String, Long> {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MainUser mainUser;

    private String occupation;

    private String insuranceNumber;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private MedicalRecord medicalRecord;
}
