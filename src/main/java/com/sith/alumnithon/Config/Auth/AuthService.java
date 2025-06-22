package com.sith.alumnithon.Config.Auth;

import java.sql.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sith.alumnithon.Config.Jwt.JwtService;
import com.sith.alumnithon.Models.User.Role;
import com.sith.alumnithon.Models.User.User;
import com.sith.alumnithon.Repositories.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails user = userRepository.findByUsername(request.username()).orElseThrow();
        return new AuthResponse(jwtService.getToken(user));

    }

    public AuthResponse register(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.password());

        User user = User.builder()
            .username(request.username())
            .password(encodedPassword)
            .firstname(request.firstname())
            .lastname(request.lastname())
            .email(request.email())
            .role(Role.USER)
            .registrationDate(new Date(System.currentTimeMillis()))
            .build();

        userRepository.save(user);

        return new AuthResponse(jwtService.getToken(user));

    }
}
