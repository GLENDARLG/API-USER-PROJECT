package apiusers.api_user_project.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


    
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configuración de rutas permitidas sin autenticación
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login", "/login/oauth2/**").permitAll() // Permite acceder a login sin autenticación
                        .anyRequest().authenticated())
                .oauth2Login(login -> login // Configuración de OAuth2 Login
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true"));

        return http.build();
    }
}


