package org.monjasa.projectclinica.model;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class MedicalRecord extends AuditableEntity<String, Long> {

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private Patient patient;

    @Column(precision = 3, scale = 2)
    private BigDecimal height;

    @Column(precision = 4, scale = 1)
    private BigDecimal weight;

    @ManyToOne
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodType;
}