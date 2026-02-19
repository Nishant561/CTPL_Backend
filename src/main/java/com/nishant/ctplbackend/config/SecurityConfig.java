package com.nishant.ctplbackend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http){

       return http.csrf(csrfConfig -> csrfConfig
                       .ignoringRequestMatchers("/api/user/delete-account").ignoringRequestMatchers("/api/roles/add-roles")
                       .ignoringRequestMatchers("/api/user/register"))
               .authorizeHttpRequests((request)-> request
                       .requestMatchers("/api/product/**","/api/error","/api/user/**","/api/roles/**").permitAll()
                       .requestMatchers("/api/category").authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();

    }

    /*@Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.withUsername("nishant").password("12345").build();

        return new InMemoryUserDetailsManager(user);
    }*/





    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /*@Bean
    public CompromisedPasswordChecker compromisedPasswordChecker(){
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }*/


}
