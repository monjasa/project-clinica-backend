package org.monjasa.projectclinica.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.model.mainuser.MainUser;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ApplicationTokenProvider {

    public static final String REFRESH_KEY = "refresh";

    @Value("${server.security.authentication.jwt.token-expires-in-seconds}")
    private Long tokenExpiresIn;

    @Value("${server.security.authentication.jwt.refresh-token-expires-in-seconds}")
    private Long refreshTokenExpiresIn;

    @Value("${server.security.authentication.jwt.base64-secret}")
    private String authSecret;

    private final MainUserRepository mainUserRepository;

    public String createAccessToken(String email) {
        MainUser mainUser = mainUserRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        ApplicationUserDetails userDetails = ApplicationUserDetails.of(mainUser);

        return Jwts.builder()
                .setSubject(String.valueOf(userDetails.getId()))
                .setIssuer(userDetails.getEmail())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(tokenExpiresIn)))
                .signWith(SignatureAlgorithm.HS512, authSecret)
                .compact();
    }

    public String createRefreshToken(String email) {
        String claimValue = RandomStringUtils.randomAlphanumeric(16) + System.nanoTime();
        Instant expirationTime = Instant.now().plusSeconds(refreshTokenExpiresIn);
        MainUser mainUser = mainUserRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);

        String refresh = Jwts.builder()
                .setSubject(email.toLowerCase())
                .setIssuer(email.toLowerCase())
                .claim(REFRESH_KEY, claimValue)
                .signWith(SignatureAlgorithm.HS512, authSecret)
                .setExpiration(Date.from(expirationTime))
                .compact();

        ApplicationToken applicationToken = createJwtToken(expirationTime.toEpochMilli(), refresh);
//        mainUser.setTokenInfo();
//        mainUserRepository.save(mainUser);

        return refresh;
    }

    public String getUserEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(authSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getIssuer();
    }

    public boolean validateToken(String authToken) {
        boolean tokenValid = true;
        try {
            Jwts.parser().setSigningKey(authSecret).parseClaimsJws(authToken);
        } catch (RuntimeException exception) {
            tokenValid = false;
        }

        return tokenValid;
    }

    private ApplicationToken createJwtToken(long expirationTimeMillis, String refresh) {
        return ApplicationToken.builder()
                .expirationTimeMillis(expirationTimeMillis)
                .refreshToken(refresh)
                .issuedAt(Instant.now())
                .build();
    }
}
