package com.example.restapi.config;

import com.example.restapi.dto.subscription.SubscriptionDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllAvailableQueries {
    @Bean
    public List<SubscriptionDto> allAvailable(){
        List<SubscriptionDto> allAvailable = new ArrayList<>();
        allAvailable.add(new SubscriptionDto("Java"));
        allAvailable.add(new SubscriptionDto("Kotlin"));
        allAvailable.add(new SubscriptionDto("PHP"));
        allAvailable.add(new SubscriptionDto("Android"));
        allAvailable.add(new SubscriptionDto("JavaScript"));
        allAvailable.add(new SubscriptionDto("Frontend"));
        allAvailable.add(new SubscriptionDto("React"));
        return allAvailable;
    }
}
