package org.monjasa.projectclinica.config;

import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "principalEmailAuditorAware")
public class PersistenceAuditingConfig {

    @Value("${auditing.anonymous-principal}")
    private String anonymousPrincipal;

    @Bean
    public AuditorAware<String> principalEmailAuditorAware() {
        return () -> Optional.of(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .filter(ApplicationUserDetails.class::isInstance)
                .map(ApplicationUserDetails.class::cast)
                .map(ApplicationUserDetails::getEmail)
                .or(this::getAnonymousPrincipal);
    }

    public Optional<String> getAnonymousPrincipal() {
        return Optional.of(anonymousPrincipal);
    }
}
