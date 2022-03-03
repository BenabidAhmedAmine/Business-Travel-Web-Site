package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {
	
	@Autowired
	SubscriptionRepository  subcriptionRepository;


}
