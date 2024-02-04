package neocode.formekouapi.security;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.service.FirebaseService;
import neocode.formekouapi.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConf {
    private final FirebaseAuthProvider firebaseAuthProvider;
    private final FirebaseService firebaseService;
    private final UserService userService;

    public FirebaseAuthFilter authFilter() {
        return new FirebaseAuthFilter(
                firebaseService,
                userService
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                //TODO: use request matcher for the filter
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(firebaseAuthProvider)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/ping")
                        .permitAll()
                        .requestMatchers("/dummy-table")
                        .permitAll()

                        //authenticated
                        .requestMatchers("/signup")
                        .authenticated()
                        .requestMatchers("/whoami")
                        .authenticated()
                        .requestMatchers("/users")
                        .authenticated()
                );
        return http.build();
    }
}