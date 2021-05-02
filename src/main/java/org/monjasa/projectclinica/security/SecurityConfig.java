package org.monjasa.projectclinica.security;

import lombok.RequiredArgsConstructor;
import org.monjasa.projectclinica.security.jwt.ApplicationTokenAuthenticationFilter;
import org.monjasa.projectclinica.security.oauth2.ApplicationOAuth2UserService;
import org.monjasa.projectclinica.security.oauth2.OAuth2AuthenticationSuccessHandler;
import org.monjasa.projectclinica.security.userdetails.ApplicationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationTokenAuthenticationFilter applicationTokenAuthenticationFilter;

    private final OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;

    private final ApplicationOAuth2UserService applicationOAuth2UserService;

    private final ApplicationUserDetailsService applicationUserDetailsService;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(applicationUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(authenticationEntryPoint, new AntPathRequestMatcher("/**"))
                .and()
                .authorizeRequests()
                .antMatchers()
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/api/oauth2/authorization")
                .and()
                .redirectionEndpoint()
                .baseUri("/api/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(applicationOAuth2UserService)
                .and()
                .successHandler(authenticationSuccessHandler)
                .and()
                .httpBasic()
                .disable()
                .formLogin()
                .disable();

        http.addFilterBefore(applicationTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
