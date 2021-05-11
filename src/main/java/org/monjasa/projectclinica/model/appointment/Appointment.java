package org.monjasa.projectclinica.model.appointment;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;
import org.monjasa.projectclinica.model.patient.Patient;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Appointment extends AuditableEntity<String, Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_slot_id")
    private AppointmentSlot appointmentSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String purpose;
}
