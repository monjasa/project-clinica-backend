package org.monjasa.projectclinica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "principalEmailAuditorAware")
public class PersistenceAuditingConfig {

    @Value("${auditing.anonymous-principal}")
    private String anonymousPrincipal;

    @Bean
    public AuditorAware<String> principalEmailAuditorAware() {
        return () -> Optional.of(anonymousPrincipal);
    }
}
