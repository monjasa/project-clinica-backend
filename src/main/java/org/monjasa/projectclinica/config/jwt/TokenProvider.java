package org.monjasa.projectclinica.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.model.CustomUserDetails;
import org.monjasa.projectclinica.model.JwtToken;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Order(1)
@Service
@RequiredArgsConstructor
public class TokenProvider {

    public static final String REFRESH_KEY = "refresh";

    @Value("${server.security.authentication.jwt.token-validity-in-seconds}")
    private long tokenExpiration;

    @Value("${server.security.authentication.jwt.refresh-token-validity-in-seconds}")
    private long refreshTokenExpiration;

    @Value("${server.security.authentication.jwt.base64-secret}")
    private String secretKey;

    private final MainUserRepository mainUserRepository;

    public String createAccessToken(String email) {
        MainUser mainUser = mainUserRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        CustomUserDetails userDetails = CustomUserDetails.of(mainUser);

        return Jwts.builder()
                .setSubject(String.valueOf(userDetails.getId()))
                .setIssuer(userDetails.getEmail())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(tokenExpiration)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String createRefreshToken(String email) {
        String random = RandomStringUtils.random(10) + System.nanoTime();
        long expireTokenMillis = Instant.now().plusSeconds(refreshTokenExpiration).toEpochMilli();
        Date validity = new Date(expireTokenMillis);
        MainUser mainUser = mainUserRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);

        String refresh = Jwts.builder()
                .setSubject(email.toLowerCase())
                .setIssuer(email.toLowerCase())
                .claim(REFRESH_KEY, random)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();

        JwtToken jwtToken = createJwtToken(expireTokenMillis, refresh);
//        mainUser.setTokenInfo();
//        mainUserRepository.save(mainUser);

        return refresh;
    }

    public String getUserEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getIssuer();
    }

    public boolean validateToken(String authToken) {
        boolean tokenValid = true;
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
        } catch (RuntimeException exception) {
            tokenValid = false;
        }

        return tokenValid;
    }

    private JwtToken createJwtToken(long expireTokenMillis, String refresh) {
        return JwtToken.builder()
                .expireTimeMillis(expireTokenMillis)
                .refreshToken(refresh)
                .issuedAt(Instant.now())
                .build();
    }
}
