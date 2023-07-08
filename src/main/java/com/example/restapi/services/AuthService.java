package com.example.restapi.services;

import com.example.restapi.dto.auth.JwtRequest;
import com.example.restapi.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public JwtResponse login(JwtRequest jwtRequest){
        return new JwtResponse();
    }
}
