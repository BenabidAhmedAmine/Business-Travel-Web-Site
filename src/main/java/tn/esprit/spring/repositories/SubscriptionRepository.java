package tn.esprit.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entities.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer>  {

	Optional<Subscription> findByTitle(String title);

}
