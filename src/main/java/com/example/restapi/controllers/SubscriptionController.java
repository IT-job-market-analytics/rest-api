package com.example.restapi.controllers;

import com.example.restapi.dto.subscription.SubscriptionDto;
import com.example.restapi.services.SubscriptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionsService subscriptionsService;

    @GetMapping(value = {"", "/"})
    public List<SubscriptionDto> getSubscriptions(Principal principal){
        return subscriptionsService.getSubscriptions(principal.getName());
    }
}
