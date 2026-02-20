package com.nishant.ctplbackend.service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CtplUserDetailsService detailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        UserDetails usr = detailsService.loadUserByUsername(username);

        if(passwordEncoder.matches(pwd,usr.getPassword())){
            return new UsernamePasswordAuthenticationToken(username,pwd,usr.getAuthorities());
        }else {
            throw new BadCredentialsException("Invalid Password!");
        }

    }

    @Override
    public boolean supports(@NonNull Class<?> authentication) {
       return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
