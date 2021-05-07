package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.monjasa.projectclinica.exception.NotFoundException;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetails;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetailsService;
import org.monjasa.projectclinica.service.MainUserService;
import org.monjasa.projectclinica.util.mapper.MainUserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainUserServiceImpl implements MainUserService {

    private final ApplicationUserDetailsService applicationUserDetailsService;

    private final MainUserRepository mainUserRepository;

    private final MainUserMapper mainUserMapper;

    @Override
    public MainUserShortInfoDto getCurrentUser() {
        ApplicationUserDetails currentUserDetails = applicationUserDetailsService.getCurrentUserDetails();
        return mainUserRepository.findById(currentUserDetails.getId())
                .map(mainUserMapper::toShortInfoDto)
                .orElseThrow(NotFoundException::new);
    }
}
