package org.monjasa.projectclinica.config;

import lombok.AllArgsConstructor;
import org.monjasa.projectclinica.config.jwt.TokenProvider;
import org.monjasa.projectclinica.model.CustomUserDetails;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenProvider tokenProvider;

    private final MainUserRepository mainUserRepository;

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(request, response, authentication);
        String email = ((CustomUserDetails) authentication.getPrincipal()).getEmail();

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String targetUrl = getDefaultTargetUrl();
        String email = ((CustomUserDetails) authentication.getPrincipal()).getEmail();
        String accessToken = tokenProvider.createAccessToken(email);
        String refreshToken = tokenProvider.createRefreshToken(email);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("accessToken", accessToken)
                .queryParam("refreshToken", refreshToken)
                .build().toUriString();
    }
}
