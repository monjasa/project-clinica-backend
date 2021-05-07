package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserShortInfoDto;
import org.monjasa.projectclinica.service.MainUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MainUserController {

    private final MainUserService mainUserService;

    @GetMapping("/current")
    public MainUserShortInfoDto getCurrentMainUser() {
        return mainUserService.getCurrentUser();
    }
}
