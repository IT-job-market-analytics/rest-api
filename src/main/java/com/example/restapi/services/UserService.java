package com.example.restapi.services;

import com.example.restapi.dto.UserCreateDto;
import com.example.restapi.exceptions.ValueAlreadyExistsException;
import com.example.restapi.models.User;
import com.example.restapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserCreateDto userCreateDto) {
        //TODO Will be used mapper
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        try {
            log.debug("Saving user: " + user);
            userRepository.save(user);
        } catch (DbActionExecutionException e) {
            log.debug("User exist: " + user);
            throw new ValueAlreadyExistsException("Username already exists");
        }
    }
}
