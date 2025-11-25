package com.thumb.palco.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "PUT", "DELETE", "PATCH");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.PUT, "/insertitem").permitAll()
                        .requestMatchers(HttpMethod.GET, "/artist").permitAll()
                        .requestMatchers(HttpMethod.GET, "/artists").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cities").permitAll()
                        .requestMatchers(HttpMethod.GET, "/city").permitAll()
                        .requestMatchers(HttpMethod.GET, "/getconcertitime").permitAll()
                        .requestMatchers(HttpMethod.GET, "/getconcertiartistcity").permitAll()
                        .requestMatchers(HttpMethod.GET, "/getconcertitimeartist").permitAll()
                        .requestMatchers(HttpMethod.GET, "/events").permitAll()
                        .requestMatchers(HttpMethod.POST, "/getconcertimese").permitAll()
                        .requestMatchers(HttpMethod.POST, "/getconcertimesecity").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/deleteitem").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/updateitemartist").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/updateitemplace").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/updateitemcity").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/updateitemtime").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}