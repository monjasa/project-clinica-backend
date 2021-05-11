package org.monjasa.projectclinica.model.employee;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;
import org.monjasa.projectclinica.model.mainuser.MainUser;

import javax.persistence.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class MedicalEmployee extends AuditableEntity<String, Long> {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MainUser mainUser;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    private BigDecimal rate;
}
