package com.apsi.config;

import com.apsi.domain.User;
import com.apsi.domain.repositories.UserRepository;
import com.apsi.security.AuthFailureHandler;
import com.apsi.security.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import java.util.Collection;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;
    private final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private AuthSuccessHandler authSuccessHandler = new AuthSuccessHandler();
    private AuthFailureHandler authFailureHandler = new AuthFailureHandler();

    @Autowired
    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .formLogin().permitAll().loginPage("/login")
                .usernameParameter("login").passwordParameter("password")
                .successHandler(authSuccessHandler).failureHandler(authFailureHandler)
                .and().logout().permitAll().logoutUrl("/logout")
                .logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
                .and().authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/logout").permitAll()
                .anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(new AuthenticationProvider() {

            @Override
            public boolean supports(Class<?> authentication) {
                return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
            }

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

                final String login = String.valueOf(token.getPrincipal());
                final String rawPassword = String.valueOf(token.getCredentials());
                final Optional<User> user = userRepository.findUserByLogin(login);
                if (!user.isPresent() || !passwordEncoder.matches(rawPassword, user.get().getPassword())) {
                    throw new BadCredentialsException("Invalid credentials");
                }

                final Collection<? extends GrantedAuthority> authorities = null;
                return new UsernamePasswordAuthenticationToken(token.getName(), token.getCredentials(), authorities);
            }
        });
    }
}