package com.example.restapi.controllers;

import com.example.restapi.dto.SubscriptionCreateDto;
import com.example.restapi.dto.UserCreateDto;
import com.example.restapi.models.Subscription;
import com.example.restapi.models.User;
import com.example.restapi.repositories.SubscriptionRepository;
import com.example.restapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @PostMapping("/create")
    public void createUser(@RequestBody UserCreateDto userCreateDto) {
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setTelegramChatId(userCreateDto.getTelegramChatId());
        userRepository.save(user);
    }

    @PostMapping("/create-subscription")
    public void createSubscription(@RequestBody SubscriptionCreateDto subscriptionCreateDto) {
        Subscription subscription = new Subscription();
        subscription.setUserId(subscriptionCreateDto.getUserId());
        subscription.setQuery(subscriptionCreateDto.getQuery());
        subscriptionRepository.save(subscription);
    }

    @GetMapping("/users")
    public List<User> getSubscription(@RequestParam("subscribedTo") String subscribedTo) {
        return userRepository.findByQuery(subscribedTo);
    }
}
