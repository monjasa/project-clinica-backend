package org.monjasa.projectclinica.repository;

import org.monjasa.projectclinica.model.mainuser.MainUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<MainUser> findByEmail(String email);
}
