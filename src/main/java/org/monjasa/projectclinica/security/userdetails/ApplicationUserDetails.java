package org.monjasa.projectclinica.security.userdetails;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.monjasa.projectclinica.model.mainuser.Authority;
import org.monjasa.projectclinica.model.mainuser.MainUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Builder
public class ApplicationUserDetails implements OAuth2User, UserDetails {

    public static ApplicationUserDetails of(MainUser mainUser) {

        List<SimpleGrantedAuthority> authorities = mainUser.getAuthorities().stream()
                .map(Authority::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return ApplicationUserDetails.builder()
                .id(mainUser.getId())
                .email(mainUser.getEmail())
                .password(RandomStringUtils.randomAlphanumeric(16))
                .authorities(authorities)
                .build();
    }

    private final Long id;

    private final String email;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    private final Map<String, Object> attributes;

    @Override
    public String getName() {
        return String.valueOf(id);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
