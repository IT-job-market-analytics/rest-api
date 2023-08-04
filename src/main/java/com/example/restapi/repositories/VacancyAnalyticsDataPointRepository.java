package com.example.restapi.repositories;

import com.example.restapi.models.VacancyAnalyticsDataPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyAnalyticsDataPointRepository extends CrudRepository<VacancyAnalyticsDataPoint, Integer>{
}
