package org.monjasa.projectclinica.config;

import org.monjasa.projectclinica.dto.MainUserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersistenceInitializationConfig {

    @Bean
    public List<MainUserDto> mainUsers() {
        return List.of(
                MainUserDto.builder()
                        .username("monjasa")
                        .email("monja.nya@gmail.com")
                        .firstName("Arthur")
                        .lastName("Kashapov")
                        .age(19)
                        .build(),
                MainUserDto.builder()
                        .username("milkaalinka17")
                        .email("milkaalinka17@gmail.com")
                        .firstName("Alina")
                        .lastName("Shumilova")
                        .age(21)
                        .build(),
                MainUserDto.builder()
                        .username("antongolda")
                        .email("a.golda@gmail.com")
                        .firstName("Anton")
                        .lastName("Golda")
                        .age(20)
                        .build(),
                MainUserDto.builder()
                        .username("yuliat")
                        .email("yulia.telyatynska@gmail.com")
                        .firstName("Yulia")
                        .lastName("Telyatynska")
                        .age(19)
                        .build()
        );
    }
}
