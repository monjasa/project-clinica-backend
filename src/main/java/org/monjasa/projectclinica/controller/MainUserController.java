package org.monjasa.projectclinica.controller;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserDto;
import org.monjasa.projectclinica.service.MainUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MainUserController {

    private final MainUserService mainUserService;

    @GetMapping("/all")
    public Page<MainUserDto> getMainUsers(Pageable pageable) {
        return mainUserService.getMainUsers(pageable);
    }
}
