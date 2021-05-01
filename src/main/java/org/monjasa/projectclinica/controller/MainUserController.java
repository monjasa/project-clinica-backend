package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.monjasa.projectclinica.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MainUserController {

    private final MainUserService mainUserService;

    @GetMapping()
    public Page<MainUserShortInfoDto> getMainUsers(Pageable pageable) {
        return mainUserService.getMainUsers(pageable);
    }

    @GetMapping("/principal")
    @PreAuthorize("hasAnyAuthority('ROLE_ALINA')")
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
