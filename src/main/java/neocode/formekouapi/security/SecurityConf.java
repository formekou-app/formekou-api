package neocode.formekouapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConf {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/ping")
                        .permitAll()
                        .requestMatchers("/dummy-table")
                        .permitAll()
                        .requestMatchers("/users/*")
                        .permitAll()
                        .requestMatchers("/signin")
                        .permitAll()
                        .requestMatchers("/signup")
                        .permitAll()
                );
        return http.build();
    }
}