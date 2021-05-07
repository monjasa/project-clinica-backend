package org.monjasa.projectclinica.security.userdetails;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsServiceImpl implements ApplicationUserDetailsService {

    private final MainUserRepository mainUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MainUser mainUser = mainUserRepository.findByEmail(username)
                .orElseThrow(NotFoundException::new);

        return ApplicationUserDetails.of(mainUser);
    }

    @Override
    public ApplicationUserDetails getCurrentUserDetails() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(ApplicationUserDetails.class::isInstance)
                .map(ApplicationUserDetails.class::cast)
                .orElseThrow(NotFoundException::new);
    }
}
