package com.example.restapi.controllers;

import com.example.restapi.dto.user.GetUserDto;
import com.example.restapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PublicController {
    private final UserService userService;

    @GetMapping("/users/byQuery/{query}")
    public List<GetUserDto> getUsersByQuery(@PathVariable String query){
        return userService.getUsersByQuery(query);
    }
}
