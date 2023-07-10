package com.example.restapi.controllers.auth;

import com.example.restapi.dto.UserCreateDto;
import com.example.restapi.dto.validation.OnCreate;
import com.example.restapi.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<ResponseStatus>  singUp(@Validated(OnCreate.class) @RequestBody UserCreateDto userCreateDto){
        log.debug("Receive userCreateDto:"+ userCreateDto);
        userService.createUser(userCreateDto);
        log.debug("User created successfully");
        return ResponseEntity.ok().build();
    }
}
