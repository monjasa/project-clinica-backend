package org.monjasa.projectclinica.model.appointment;

import lombok.Getter;
import lombok.Setter;
import org.monjasa.projectclinica.model.clinic.Clinic;
import org.monjasa.projectclinica.model.employee.MedicalEmployee;
import org.monjasa.projectclinica.model.jpa.AuditableEntity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "appointment_slot")
public class AppointmentSlot extends AuditableEntity<String, Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_employee_id")
    private MedicalEmployee medicalEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDatetime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDatetime;
}
