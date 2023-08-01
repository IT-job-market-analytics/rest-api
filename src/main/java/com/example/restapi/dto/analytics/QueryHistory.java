package com.example.restapi.dto.analytics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryHistory {
    private String date;
    private int vacancyCount;
    private double averageSalary;
}
