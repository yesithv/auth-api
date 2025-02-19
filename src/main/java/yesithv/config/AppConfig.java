package yesithv.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desactiva CSRF si usas JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( // Permitir sin autenticación
                                "/auth-api/v1/register",
                                "/auth-api/v1/login",
                                "/auth-api/v1/health/**"
                        ).permitAll()
                        .anyRequest().authenticated() // Todo lo demás requiere autenticación
                );

        return http.build();
    }
}
