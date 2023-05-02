package ru.beganov.tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeRequests()
                .requestMatchers("/design", "/orders").access("hasRole('USER')")
                .requestMatchers("/", "/**").access("permitAll()")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .build();
    }

}
