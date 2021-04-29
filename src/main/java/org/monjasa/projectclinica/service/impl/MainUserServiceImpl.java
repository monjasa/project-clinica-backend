package org.monjasa.projectclinica.service.impl;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.dto.MainUserDto;
import org.monjasa.projectclinica.repository.MainUserRepository;
import org.monjasa.projectclinica.service.MainUserService;
import org.monjasa.projectclinica.util.mapper.MainUserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainUserServiceImpl implements MainUserService {

    private final MainUserRepository mainUserRepository;

    private final MainUserMapper mainUserMapper;

    private final List<MainUserDto> mainUsers;

    @PostConstruct
    public void initializeMainUsers() {
        mainUsers.stream()
                .map(mainUserMapper::toEntity)
                .forEach(mainUserRepository::save);
    }

    @Override
    public Page<MainUserDto> getMainUsers(Pageable pageable) {
        return mainUserRepository.findAll(pageable)
                .map(mainUserMapper::toDto);
    }
}
