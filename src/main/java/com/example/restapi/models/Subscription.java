package com.example.restapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Subscriptions")
@Data
public class Subscription {
    @Id
    private int id;

    @Column("user_id")
    private int userId;

    @Column("query")
    private String query;
}