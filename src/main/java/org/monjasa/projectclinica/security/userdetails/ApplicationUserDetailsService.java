package org.monjasa.projectclinica.security.userdetails;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserDetailsService extends UserDetailsService {

    ApplicationUserDetails getCurrentUserDetails();
}
