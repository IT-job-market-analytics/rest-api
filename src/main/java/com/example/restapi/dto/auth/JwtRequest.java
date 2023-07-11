package com.example.restapi.dto.auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull(message = "username must by not null")
    @NotEmpty(message = "username must by not empty")
    private String username;

    @NotNull(message = "password must by not null")
    @NotEmpty(message = "password must by not empty")
    private String password;
}
