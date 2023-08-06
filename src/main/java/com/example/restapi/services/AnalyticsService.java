package com.example.restapi.services;

import com.example.restapi.dto.analytics.GetQueryDataDto;
import com.example.restapi.dto.analytics.GetQueryHistoryDto;
import com.example.restapi.exceptions.ResourceNotFoundException;
import com.example.restapi.mappers.VacancyAnalyticsMapper;
import com.example.restapi.models.VacancyAnalyticsDataPoint;
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
        LocalDate maxDate = vacancyRepository
                .findFirstByOrderByDateDesc()
                .map(VacancyAnalyticsDataPoint::getDate)
                .orElseThrow(()->new ResourceNotFoundException("Vacancies not found"));

        return vacancyAnalyticsMapper.toQueryDataDto(
                vacancyRepository.findVacancyAnalyticsDataPointByDate(maxDate)
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
                        Sort.by("date").descending()
                )
        );
    }
}
