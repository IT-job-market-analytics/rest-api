package com.example.restapi.services;

import com.example.restapi.dto.analytics.QueryData;
import com.example.restapi.dto.analytics.QueryHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {
    public List<QueryData> byQuery() {

        List<QueryData> queryDataList = new ArrayList<>();
        queryDataList.add(new QueryData("Java", 22, 100000.33));
        queryDataList.add(new QueryData("Kotlin", 21, 99000.00));

        return queryDataList;
    }

    public List<QueryHistory> historyQuery(String query, int depth) {

        List<QueryHistory> queryHistoryList = new ArrayList<>();
        queryHistoryList.add(new QueryHistory("01.01.2023", 31, 100000.33));
        queryHistoryList.add(new QueryHistory("02.01.2023", 31, 99000.33));

        return queryHistoryList;
    }
}
