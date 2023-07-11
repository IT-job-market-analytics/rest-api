package com.example.restapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "Test Controller", description = "test endpoint")
public class TestController {
    @GetMapping("")
    public String testMethod(){
        return "Authorize test message";
    }
}
