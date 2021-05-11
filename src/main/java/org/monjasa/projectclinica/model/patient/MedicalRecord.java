package org.monjasa.projectclinica.model.patient;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "medical_record")
public class MedicalRecord extends AuditableEntity<String, Long> {

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private Patient patient;

    @Column(precision = 3, scale = 2)
    private BigDecimal height;

    @Column(precision = 4, scale = 1)
    private BigDecimal weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodType;
}
