package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
	
	

}
