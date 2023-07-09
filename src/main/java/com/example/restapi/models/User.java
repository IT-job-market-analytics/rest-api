package com.example.restapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

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
    private Integer telegramChatId;

    @Transient
    private Set<Role> roles;

}
