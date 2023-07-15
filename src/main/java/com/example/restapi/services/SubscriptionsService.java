package com.example.restapi.services;

import com.example.restapi.config.AllAvailableQueries;
import com.example.restapi.dto.subscription.SubscriptionDto;
import com.example.restapi.exceptions.QueryNotFoundExceptions;
import com.example.restapi.exceptions.ResourceNotFoundException;
import com.example.restapi.exceptions.ValueAlreadyExistsException;
import com.example.restapi.mappers.SubscriptionsMapper;
import com.example.restapi.models.Subscription;
import com.example.restapi.models.User;
import com.example.restapi.repositories.SubscriptionRepository;
import com.example.restapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<SubscriptionDto> addSubscription(String username, String query) {
        checkAllAvailableQueries(query);
        int userId = getUser(username);

        try {
            subscriptionRepository.save(
                    Subscription.builder()
                            .userId(userId)
                            .query(query)
                            .build()
            );
        }catch (DbActionExecutionException e){
            throw new ValueAlreadyExistsException("User already subscribed to this query");
        }
        return getSubscriptions(username);
    }

    public List<SubscriptionDto> removeSubscription(String username, String query) {
        checkAllAvailableQueries(query);
        int userId = getUser(username);

        Subscription subscription = subscriptionRepository.findSubscriptionByUserIdAndQuery(userId, query)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription query does not exist"));
        subscriptionRepository.delete(subscription);

        return getSubscriptions(username);
    }

    private int getUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user.getId();
    }

    private void checkAllAvailableQueries(String query) {
        allAvailableQueries.allAvailable().stream()
                .map(SubscriptionDto::getQuery)
                .filter(q -> q.equalsIgnoreCase(query))
                .findFirst()
                .orElseThrow(() -> new QueryNotFoundExceptions("Non supported query"));
    }


}
