package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Service.SubscriptionServiceImpl;

import tn.esprit.spring.Entity.Subscription;




@RequestMapping("/subscription")
@RestController
public class SubscriptionRestController {
	@Autowired
	SubscriptionServiceImpl subscriptionService;
	
	
	
	@ApiOperation(value = "Ajouter une subscription ")
	@PostMapping("/add-subscription")
	@ResponseBody
	public Subscription addSubscription(@RequestBody Subscription subscription)
	{
		Subscription s  = subscriptionService.addSubscription(subscription);
	return s;
	
}
	@ApiOperation(value = "Mettre a jour une subscription")
	@PutMapping("/modify-subscription")
	@ResponseBody
	public Subscription modifySubscription(@RequestBody Subscription subscription) {
	return subscriptionService.updateSubscription(subscription);
	
}
	
	
	
	@ApiOperation(value = "Récupérer la liste des subscription")
	@GetMapping("/retrieve-all-subscriptions")
	@ResponseBody
	public List<Subscription> getSubscriptions() {
	List<Subscription> listSubscriptions= subscriptionService.retrieveAllSubscriptions();
	return listSubscriptions;
	}
	
	@ApiOperation(value = "Supprimer une subscription par Id")
	@DeleteMapping("/remove-subscription/{subscriptionId}")
	@ResponseBody
	public void removeSubscription(@PathVariable("subscriptionId") Integer subscriptionId) {
		subscriptionService.deleteSubscription(subscriptionId);
	}
	
	@GetMapping("/retrieve-subscription")
	@ResponseBody
	Optional<Subscription> retrieveSubscription(String title){
	return subscriptionService.retrieveSubscription(title);
	}
	
	}