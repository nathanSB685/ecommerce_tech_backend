package br.com.nathan.ecommerce_tech_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Ensina o Spring Boot a usar o algoritmo BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configura as permissões das rotas
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita proteção CSRF (necessário para APIs REST)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll() // Libera o cadastro
                        .requestMatchers("/api/produtos/**").permitAll()
                        // .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Descomente se o CORS reclamar
                        .anyRequest().authenticated() // Bloqueia todo o resto
                );
        return http.build();
    }

}
