package org.monjasa.projectclinica.repository;

import org.monjasa.projectclinica.model.employee.MedicalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalEmployeeRepository extends JpaRepository<MedicalEmployee, Long> {
}
