package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.SubscriptionRepository;
import tn.esprit.spring.Repository.UserRepository;

import tn.esprit.spring.Entity.Etat;
import tn.esprit.spring.Entity.Subscription;
import tn.esprit.spring.Entity.User;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	UserRepository userRepository;
	
	//@Autowired
  //  private MailSender sender;
	
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

	@Override
	public void ajouterEtaffectersubscriptions(Subscription s, Long userId) {
		s.setEtat(Etat.subscribe);
		subscriptionRepository.save(s);
		
		User user = userRepository.findById(userId).orElse(null);
		
			s.setUser(user);
			
		subscriptionRepository.save(s);
	}
	
	
	
	
	
	
	
	
	
	
	

	//@Override
//	public void senMail(long userId) {
	//	User u = userRepository.findById(userId).orElse(null);
      // SimpleMailMessage msg = new SimpleMailMessage();

       // msg.setFrom("rahma.chaabane@esprit.tn");
      //  msg.setTo(u.getEmail());
      //  msg.setSubject("Champ de saisie du sujet");
      //  msg.setText("Champ de saisie du corps");
     //  this.send("msg");

	
		
	

	

	

}
