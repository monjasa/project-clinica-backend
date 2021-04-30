package org.monjasa.projectclinica.repository;

import org.monjasa.projectclinica.model.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {
}
