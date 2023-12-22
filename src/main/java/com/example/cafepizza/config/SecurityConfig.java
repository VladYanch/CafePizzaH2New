package com.example.cafepizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final String[] AUTH_WHITELIST = {
            "/api/**",
            "/login",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/",
            "/style.css",
            "/img/**",
            "/error",
            "/pizzas",
            "/cafes",
            "/menu"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .logout((logout) -> logout.logoutUrl("/logout").permitAll()
                        .logoutSuccessUrl("/"))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                );

        return http.build();
    }
}