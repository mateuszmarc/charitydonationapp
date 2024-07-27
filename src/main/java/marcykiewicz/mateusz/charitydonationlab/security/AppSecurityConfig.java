package marcykiewicz.mateusz.charitydonationlab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security, HttpSecurity httpSecurity) throws Exception {

        security
                .cors(withDefaults())
                .csrf(configurer -> configurer.disable())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers(
                        "/register/**",
                        "/login/**",
                        "/about/**",
                        "/contact/**",
                        "/main/**",
                        "/css/**",
                        "/images/**"
                ).permitAll()
                        .requestMatchers("/users/**").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated()
                );

        return httpSecurity.build();
    }

}
