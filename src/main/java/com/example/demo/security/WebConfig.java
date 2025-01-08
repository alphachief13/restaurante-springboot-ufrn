package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebConfig  {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configure(http))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeConfig ->
            authorizeConfig
            .requestMatchers(HttpMethod.GET,"/cliente/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.POST,"/cliente").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/cliente").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/cliente/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/cliente").permitAll()

                    .requestMatchers(HttpMethod.GET, "/produto").permitAll()
                    .requestMatchers(HttpMethod.GET, "/produto/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.POST, "/produto").permitAll()
                    
                    .requestMatchers(HttpMethod.PUT, "/produto/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/produto/{id:[0-9]+}").permitAll()
                    
                    .requestMatchers(HttpMethod.GET, "/categoria").permitAll()
                    .requestMatchers(HttpMethod.GET, "/categoria/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.POST, "/categoria").permitAll()
                    
                    .requestMatchers(HttpMethod.PUT, "/categoria/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/categoria/{id:[0-9]+}").permitAll()

                    .requestMatchers(HttpMethod.GET, "/pedido/{id}/produtos").permitAll() 
                    .requestMatchers(HttpMethod.POST, "/pedido").permitAll() 
                    .requestMatchers(HttpMethod.GET, "/pedido").permitAll() 
                    .requestMatchers(HttpMethod.GET, "/pedido/{id}").permitAll() 
                    .requestMatchers(HttpMethod.PUT, "/pedido/{id}").permitAll() 
                    .requestMatchers(HttpMethod.DELETE, "/pedido/{id}").permitAll() 
                    
                    .requestMatchers(HttpMethod.GET, "/produtoPedido").permitAll()
                    .requestMatchers(HttpMethod.POST, "/produtoPedido").permitAll()
                    .requestMatchers(HttpMethod.GET, "/produtoPedido/{id}").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/produtoPedido/{id}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/produtoPedido/{id}").permitAll()

            ).build();
    }
}