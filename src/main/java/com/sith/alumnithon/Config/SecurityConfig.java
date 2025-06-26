package com.sith.alumnithon.Config;


import java.sql.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sith.alumnithon.Config.Jwt.JwtAuthenticationFilter;
import com.sith.alumnithon.Models.User.Country;
import com.sith.alumnithon.Models.User.Role;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Repositories.UserRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authProvider = authProvider;
    }

    @Bean
    CommandLineRunner initUsers(UserRepository repository) {
        return args -> {
            User user = User.builder()
            .username("admin")
            .password("admin")
            .firstname("Jhon")
            .lastname("Doe")
            .country(Country.MEXICO)
            .email("jhondoe@admin.com")
            .age(20)
            .role(Role.ADMIN)
            .registrationDate(new Date(System.currentTimeMillis()))
            .build();

            repository.save(user);

        List<User> users = List.of(
            User.builder().username("user1").password("pass1").firstname("Ana").lastname("García")
                .country(Country.MEXICO).email("ana1@test.com").age(25).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user2").password("pass2").firstname("Luis").lastname("Ramírez")
                .country(Country.COLOMBIA).email("luis2@test.com").age(30).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user3").password("pass3").firstname("Marta").lastname("Pérez")
                .country(Country.MEXICO).email("marta3@test.com").age(28).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user4").password("pass4").firstname("Carlos").lastname("Díaz")
                .country(Country.ARGENTINA).email("carlos4@test.com").age(32).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user5").password("pass5").firstname("Lucía").lastname("Santos")
                .country(Country.SPAIN).email("lucia5@test.com").age(22).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user6").password("pass6").firstname("Pedro").lastname("Fernández")
                .country(Country.CHILE).email("pedro6@test.com").age(35).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user7").password("pass7").firstname("Laura").lastname("Herrera")
                .country(Country.MEXICO).email("laura7@test.com").age(26).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user8").password("pass8").firstname("Diego").lastname("Torres")
                .country(Country.PERU).email("diego8@test.com").age(29).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user9").password("pass9").firstname("Sofía").lastname("Morales")
                .country(Country.MEXICO).email("sofia9@test.com").age(24).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build(),

            User.builder().username("user10").password("pass10").firstname("Javier").lastname("Cruz")
                .country(Country.URUGUAY).email("javier10@test.com").age(31).role(Role.USER)
                .registrationDate(new Date(System.currentTimeMillis())).build()
        );

        // Guardar todos los usuarios
        repository.saveAll(users);

        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf ->
                    csrf
                    .disable())
                .authorizeHttpRequests(authRequest ->
                    authRequest
                        .requestMatchers("/**").permitAll()     // Acceso permitido por motivos de desarrollo
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api/**").permitAll() // Acceso a las rutas api permitido por motivos de desarrollo
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()))
                .sessionManagement(sessionManager ->
                sessionManager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
