package com.example.restapi.dto;

import lombok.Data;

@Data
public class UserCreateDto {
    private String username;

    private String password;

    private int telegramChatId;
}
