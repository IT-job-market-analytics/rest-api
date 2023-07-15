package com.example.restapi.controllers;

import com.example.restapi.dto.user.EditUserDto;
import com.example.restapi.dto.user.GetUserDto;
import com.example.restapi.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User Controller", description = "get and update user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = {"/"})
    public ResponseEntity<GetUserDto> getUser(Principal principal) {
        String currentUserName = principal.getName();

        return new ResponseEntity<>(
                userService.getUserByUsername(currentUserName),
                HttpStatus.OK
        );
    }

    @PostMapping(value = {"/"})
    public ResponseEntity<GetUserDto> updateUser(@Validated @RequestBody EditUserDto editUserDto, Principal principal) {
        return new ResponseEntity<>(
                userService.update(editUserDto, principal.getName()),
                HttpStatus.OK
        );
    }

    @GetMapping("/byQuery/{query}")
    public List<GetUserDto> getUsersByQuery(@PathVariable String query){
        return userService.getUsersByQuery(query);
    }
}
