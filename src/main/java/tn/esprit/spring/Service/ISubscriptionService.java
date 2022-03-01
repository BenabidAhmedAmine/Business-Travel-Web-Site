package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Subscription;


public interface ISubscriptionService {
	
	public Subscription addSubscription(Subscription subscription);
	public Subscription updateSubscription(Subscription subscription);
	
	public List<Subscription>retrieveAllSubscriptions();
	void deleteSubscription(Integer subscriptionId);
	
	Optional<Subscription> retrieveSubscription(String title);
}
