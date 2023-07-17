package com.example.restapi.controllers;

import com.example.restapi.dto.subscription.SubscriptionDto;
import com.example.restapi.security.JwtEntity;
import com.example.restapi.services.SecurityService;
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
    private final SecurityService securityService;

    @GetMapping(value = {"", "/"})
    public List<SubscriptionDto> getSubscriptions(Principal principal) {
        JwtEntity user = securityService.getUser(principal);
        return subscriptionsService.getSubscriptions(user.getId());
    }

    @GetMapping("/allAvailable")
    public List<SubscriptionDto> getAllAvailableSubscriptions() {
        return subscriptionsService.getAllAvailableSubscriptions();
    }

    @PostMapping("/{query}")
    public List<SubscriptionDto> addSubscription(Principal principal, @PathVariable String query) {
        JwtEntity user = securityService.getUser(principal);
        return subscriptionsService.addSubscription(user.getId(), query);
    }

    @DeleteMapping("/{query}")
    public List<SubscriptionDto> removeSubscription(Principal principal, @PathVariable String query) {
        JwtEntity user = securityService.getUser(principal);
        return subscriptionsService.removeSubscription(user.getId(), query);
    }
}
