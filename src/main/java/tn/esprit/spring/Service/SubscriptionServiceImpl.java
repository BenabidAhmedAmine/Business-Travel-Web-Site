package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repositories.SubscriptionRepository;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Subscription;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {
	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Override
	public Subscription addSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

	@Override
	public Subscription updateSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}



	@Override
	public List<Subscription> retrieveAllSubscriptions() {
		return (List<Subscription>) subscriptionRepository.findAll();
	}

	

	@Override
	public void deleteSubscription(Integer subscriptionId) {
		subscriptionRepository.deleteById(subscriptionId);
	}

	@Override
	public Optional<Subscription> retrieveSubscription(String title) {
		return subscriptionRepository.findByTitle((String) title) ;
	}

	
		
	

	

	

}
