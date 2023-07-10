package com.example.restapi.dto;

import com.example.restapi.dto.validation.OnCreate;
import com.example.restapi.dto.validation.OnUpdate;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
@Data
public class UserCreateDto {
    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 3, max = 50, message = "Username length must be between 3 and 50 characters", groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 6, max = 50, message = "Password length must be between 6 and 50 characters", groups = {OnUpdate.class, OnCreate.class})
    private String password;
}
