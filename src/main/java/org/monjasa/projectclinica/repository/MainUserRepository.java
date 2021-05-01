package org.monjasa.projectclinica.repository;

import org.monjasa.projectclinica.model.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {

    Optional<MainUser> findByEmail(String email);
}
