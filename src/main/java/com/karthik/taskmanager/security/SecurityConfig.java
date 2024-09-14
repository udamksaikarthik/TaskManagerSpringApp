package com.karthik.taskmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/**", "/js/**", "/images/**","/signup","/login").permitAll() // Public paths
                .anyRequest().authenticated() // All other paths require authentication
            )
            .formLogin(form -> form
            	.defaultSuccessUrl("/", true)
            	.failureHandler(customAuthenticationFailureHandler())
                .loginPage("/login") // Custom login page
                .permitAll()
            )
            .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/logout"))
            .logout(config -> config.logoutSuccessUrl("/")
            		);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    
}