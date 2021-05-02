package org.monjasa.projectclinica.security.oauth2;

import lombok.AllArgsConstructor;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetails;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ApplicationOAuth2UserService extends DefaultOAuth2UserService {

    private final MainUserRepository mainUserRepository;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        MainUser mainUser = mainUserRepository.findByEmail(oAuth2User.getAttribute("email"))
                .orElseThrow(NotFoundException::new);

        return ApplicationUserDetails.of(mainUser);
    }
}