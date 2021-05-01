package org.monjasa.projectclinica.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
@Builder
public class CustomUserDetails implements OAuth2User, UserDetails {

    public static CustomUserDetails of(MainUser mainUser) {
        return CustomUserDetails.builder()
                .id(mainUser.getId())
                .email(mainUser.getEmail())
                .password("")
                .authorities(Collections.emptyList())
                .attributes(Collections.emptyMap())
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
