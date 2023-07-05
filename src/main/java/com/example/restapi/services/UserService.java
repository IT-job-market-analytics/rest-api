package com.example.restapi.services;

import com.example.restapi.dto.UserCreateDto;
import com.example.restapi.exceptions.ValueAlreadyExistsException;
import com.example.restapi.models.User;
import com.example.restapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserCreateDto userCreateDto) {
        //TODO Will be used mapper
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        try {
            userRepository.save(user);
        } catch (DbActionExecutionException e) {
            throw new ValueAlreadyExistsException("Username already exists");
        }
    }
}
