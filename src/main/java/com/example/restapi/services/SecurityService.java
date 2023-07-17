package com.example.restapi.services;

import com.example.restapi.exceptions.ResourceNotFoundException;
import com.example.restapi.security.JwtEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class SecurityService {

    public JwtEntity getUser(Principal principal) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
            JwtEntity jwtEntity = (JwtEntity) authenticationToken.getPrincipal();

            return jwtEntity;
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }
}
