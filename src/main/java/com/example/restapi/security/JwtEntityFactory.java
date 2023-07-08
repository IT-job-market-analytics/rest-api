package com.example.restapi.security;

import com.example.restapi.models.Role;
import com.example.restapi.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtEntityFactory {
    public static JwtEntity create(User user){
        return new JwtEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                //mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
                //TODO Передать роли
                mapToGrantedAuthorities(new ArrayList<>(Role.ROLE_USER.ordinal()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }
}
