package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.Etat;
import tn.esprit.spring.Entity.Subscription;


public interface ISubscriptionService {
	
	public Subscription addSubscription(Subscription subscription);
	public Subscription updateSubscription(Subscription subscription);
	
	public List<Subscription>retrieveAllSubscriptions();
	void deleteSubscription(Integer subscriptionId);
	
	public List<Subscription> listSubscriptionParEtat(Etat etat);
	
	
	
	
	public void ajouterEtaffectersubscriptions(Subscription s, Long Id );
		
	
	
	

	Optional<Subscription> retrieveSubscription(String title);
}
