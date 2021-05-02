package org.monjasa.projectclinica.security.oauth2;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.security.jwt.ApplicationTokenProvider;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${spring.security.oauth2.client.registration.google.target-uri}")
    private String targetUri;

    private final ApplicationTokenProvider applicationTokenProvider;

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(request, response, authentication);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ApplicationUserDetails userDetails = (ApplicationUserDetails) authentication.getPrincipal();
        String email = userDetails.getEmail();
        String accessToken = applicationTokenProvider.createAccessToken(email);
        String refreshToken = applicationTokenProvider.createRefreshToken(email);

        return UriComponentsBuilder.fromHttpUrl(targetUri)
                .queryParam("accessToken", accessToken)
                .queryParam("refreshToken", refreshToken)
                .build().toUriString();
    }
}
