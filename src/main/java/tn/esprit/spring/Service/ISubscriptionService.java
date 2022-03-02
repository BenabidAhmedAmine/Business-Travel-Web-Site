package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.Subscription;


public interface ISubscriptionService {
	
	public Subscription addSubscription(Subscription subscription);
	public Subscription updateSubscription(Subscription subscription);
	
	public List<Subscription>retrieveAllSubscriptions();
	void deleteSubscription(Integer subscriptionId);
	
	
	
	
	
	
	public void ajouterEtaffectersubscriptions(Subscription s, Long userId);
		
	
	
	

	Optional<Subscription> retrieveSubscription(String title);
}
