package com.example.restapi.services;

import com.example.restapi.config.AllAvailableQueries;
import com.example.restapi.dto.subscription.SubscriptionDto;
import com.example.restapi.exceptions.ResourceNotFoundException;
import com.example.restapi.mappers.SubscriptionsMapper;
import com.example.restapi.models.User;
import com.example.restapi.repositories.SubscriptionRepository;
import com.example.restapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionsMapper subscriptionsMapper;
    private final AllAvailableQueries allAvailableQueries;

    public List<SubscriptionDto> getSubscriptions(String username) {
        return subscriptionsMapper.toDtoList(
                userRepository.
                        findByUsername(username)
                        .map(User::getId)
                        .map(subscriptionRepository::findAllByUserId)
                        .orElseThrow(() -> new ResourceNotFoundException("Subscriptions not found"))
        );
    }

    public List<SubscriptionDto> getAllAvailableSubscriptions() {

        return allAvailableQueries.allAvailable();
    }
}
