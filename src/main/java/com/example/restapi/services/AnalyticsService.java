package com.example.restapi.services;

import com.example.restapi.dto.analytics.GetQueryDataDto;
import com.example.restapi.dto.analytics.GetQueryHistoryDto;
import com.example.restapi.mappers.VacancyAnalyticsMapper;
import com.example.restapi.repositories.VacancyAnalyticsDataPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final VacancyAnalyticsDataPointRepository vacancyRepository;
    private final VacancyAnalyticsMapper vacancyAnalyticsMapper;

    public List<GetQueryDataDto> byQuery() {
        return vacancyAnalyticsMapper.toQueryDataDto(
                vacancyRepository.findVacancyAnalyticsDataPointByDate(LocalDate.now())
        );
    }

    public List<GetQueryHistoryDto> historyQuery(String query, int depth) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(depth);

        return vacancyAnalyticsMapper.toQueryHistoryDto(
                vacancyRepository.findVacancyAnalyticsDataPointByQueryAndDateBetween(
                        query,
                        startDate,
                        endDate,
                        Sort.by("date").ascending()
                )
        );
    }
}
