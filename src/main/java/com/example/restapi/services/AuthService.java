package com.example.restapi.services;

import com.example.restapi.dto.auth.JwtRequest;
import com.example.restapi.dto.auth.JwtResponse;
import com.example.restapi.models.Role;
import com.example.restapi.models.User;
import com.example.restapi.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        User user = userService.getByUsername(loginRequest.getUsername());
        System.out.println(user);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());

        //TODO передать рольAuthentication
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), Collections.singleton(Role.ROLE_USER)));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));

        return jwtResponse;
    }
}
