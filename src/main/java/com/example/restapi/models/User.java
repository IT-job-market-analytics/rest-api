package com.example.restapi.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Users")
@Data
public class User {
    @Id
    private int id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("telegram_chat_id")
    private int telegramChatId;

}
