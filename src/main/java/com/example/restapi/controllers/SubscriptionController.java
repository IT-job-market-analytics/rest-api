package com.example.restapi.controllers;

import com.example.restapi.dto.subscription.SubscriptionDto;
import com.example.restapi.services.SubscriptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionsService subscriptionsService;

    @GetMapping(value = {"", "/"})
    public List<SubscriptionDto> getSubscriptions(Principal principal) {
        return subscriptionsService.getSubscriptions(principal.getName());
    }

    @GetMapping("/allAvailable")
    public List<SubscriptionDto> getAllAvailableSubscriptions() {
        return subscriptionsService.getAllAvailableSubscriptions();
    }

    @PostMapping("/{query}")
    public List<SubscriptionDto> addSubscription(Principal principal, @PathVariable String query) {
        return subscriptionsService.addSubscription(principal.getName(), query);
    }

    @DeleteMapping("/{query}")
    public List<SubscriptionDto> removeSubscription(Principal principal, @PathVariable String query) {
        return subscriptionsService.removeSubscription(principal.getName(), query);
    }
}