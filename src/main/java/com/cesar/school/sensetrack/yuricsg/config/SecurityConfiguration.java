package com.cesar.school.sensetrack.yuricsg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.cesar.school.sensetrack.yuricsg.config.ApiKeyAuthFilter;

import jakarta.servlet.Filter;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, ApiKeyAuthFilter apiKeyAuthFilter) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .addFilterBefore((Filter) apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                .requestMatchers("/api/sensors/**").permitAll() // O filtro cuidará da API Key
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String username = "user_" + UUID.randomUUID().toString().substring(0, 8);
        String rawPassword = UUID.randomUUID().toString().substring(0, 8);

        System.out.println("Gerado usuário: " + username);
        System.out.println("Senha: " + rawPassword);

        return new InMemoryUserDetailsManager(
                User.withUsername(username)
                    .password(passwordEncoder().encode(rawPassword))
                    .roles("USER")
                    .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
