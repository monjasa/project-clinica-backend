package org.monjasa.projectclinica.service;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.model.CustomUserDetails;
import org.monjasa.projectclinica.model.MainUser;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MainUserRepository mainUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MainUser mainUser = mainUserRepository.findByEmail(username)
                .orElseThrow(NotFoundException::new);

        return CustomUserDetails.of(mainUser);
    }
}
