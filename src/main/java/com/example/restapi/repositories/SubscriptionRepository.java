package com.example.restapi.repositories;

import com.example.restapi.models.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    Optional<Subscription> findByUserId(int userId);
    List<Subscription> findAllByUserId(int userId);
}
