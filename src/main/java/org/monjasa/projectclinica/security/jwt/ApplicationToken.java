package org.monjasa.projectclinica.security.jwt;

import lombok.*;

import javax.persistence.Embeddable;

import java.time.Instant;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ApplicationToken {

    private String refreshToken;

    private Long expirationTimeMillis;

    private Instant issuedAt;
}
