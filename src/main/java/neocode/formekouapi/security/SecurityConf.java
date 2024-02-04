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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConf {
    private final FirebaseAuthProvider firebaseAuthProvider;
    private final FirebaseService firebaseService;
    private final UserService userService;

    public FirebaseAuthFilter configureFilter(RequestMatcher matcher){
        return new FirebaseAuthFilter(firebaseService, userService, matcher);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer
                        .configurationSource( request ->
                            new CorsConfiguration().applyPermitDefaultValues()
                        )
                )
                //authenticated
                .addFilterBefore(configureFilter(
                        new OrRequestMatcher(
                                new AntPathRequestMatcher("/ping"),
                                new AntPathRequestMatcher("/dummy-table"),
                                new AntPathRequestMatcher("/signup")
                        )),
                        UsernamePasswordAuthenticationFilter.class
                )
                .authenticationProvider(firebaseAuthProvider)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/ping")
                        .permitAll()
                        .requestMatchers("/dummy-table")
                        .permitAll()
                        .requestMatchers("/signup")
                        .permitAll()
                        .requestMatchers("/whoami")
                        .authenticated()
                        .requestMatchers("/users")
                        .authenticated()
                );
        return http.build();
    }
}