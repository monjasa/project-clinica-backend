package org.monjasa.projectclinica.model;

import lombok.*;

import javax.persistence.Embeddable;

import java.time.Instant;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JwtToken {

    private String refreshToken;

    private Long expireTimeMillis;

    private Instant issuedAt;
}
