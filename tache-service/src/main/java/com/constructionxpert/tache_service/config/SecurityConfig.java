package com.constructionxpert.tache_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filtercjain///////////");

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .requestMatchers("/api/tasks" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "" +
                                        "/**").hasRole("USER")
                                .anyRequest().authenticated()

                )
                .formLogin(formLogin ->formLogin.disable());
        http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
