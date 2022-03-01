package tn.esprit.spring.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.Entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer>  {

	Optional<Subscription> findByTitle(String title);

}
