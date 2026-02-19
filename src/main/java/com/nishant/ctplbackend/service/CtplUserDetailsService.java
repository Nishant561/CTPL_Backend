package com.nishant.ctplbackend.service;


import com.nishant.ctplbackend.model.user.Users;
import com.nishant.ctplbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CtplUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Users foundUser =userRepository.findByUserEmail(email).orElseThrow(()-> new UsernameNotFoundException("User is not registered" + email));
        List<GrantedAuthority>  authorities = foundUser.getUserRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toList());

       return new User(foundUser.getUserEmail(),foundUser.getUserPassword(),authorities);


    }
}
