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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Service.IFeedbackService;
@RestController
public class FeedBackController {
	@Autowired
	IFeedbackService feedBackService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/ajouterEtaffecterrFeedBack/{Id}")
	@ResponseBody
	public void  ajouterEtaffecterrFeedBack(@RequestBody FeedBack f, @PathVariable("Id") long Id) {
		feedBackService.ajouterEtaffecterrFeedBack(f, Id);
	}
	
	@GetMapping("/TRI/{field}")
	@ResponseBody
	List<FeedBack> retrieveComplaintswithsorting(@PathVariable("field") String field){
	return feedBackService.retrieveFeedBackwithsorting(field);
	}
	
	@PutMapping("/updateFeedBack/{idFeedBack}/{note}")
	@ResponseBody
	public String updateFeedBack(@PathVariable("idFeedBack") Long idFeedBack,@PathVariable("note") int note) {

		return feedBackService.updateFeedBack(idFeedBack,note);

	}
	
	@DeleteMapping("/delete-feedBack/{idFeedBack}")
	void deleteFeedBack(@PathVariable(name="idFeedBack")Long idFeedBack){
		feedBackService.deleteFeedBack(idFeedBack);
	}

	@GetMapping("/retrieve-ALLfeedBack")
	@ResponseBody
	List<FeedBack> retrieveAllFeedBack(){
	return feedBackService.retrieveAllFeedBacks();
	}
	@GetMapping("/retrieve-ONE/{idFeedBack}")
	@ResponseBody
	Optional<FeedBack> retrieveONE(@PathVariable(name="idFeedBack")Long idFeedBack){
	return feedBackService.retrieveFeedBack(idFeedBack);
	}
	
	@GetMapping(value ="/retrieve-last-3-reviews")
	@ResponseBody
	public List<FeedBack> getLastReviews() 
	{
	
	return feedBackService.listLastReviews();
    
	} 
	
	@GetMapping(value ="/Nbr-review-ParUser/{Id}")
	@ResponseBody
	public int nbReview(@PathVariable("Id") Long Id) 
	{
	
	return feedBackService.nbReview(Id);
    
	} 
	@GetMapping(value ="/note-somme-ParUser/{Id}")
	@ResponseBody
	public float SommeNoteparuser(@PathVariable("Id") Long Id) 
	{
			
	return feedBackService.SommeNote(Id);
		    
	}
	
	/*@GetMapping(value = "/top_note")
	@ResponseBody
	public Optional<FeedBack> top_note_user() {
	 Long l = feedBackService.top_note_user();
		Optional<FeedBack> f = feedBackService.getfeedbackById(l);
		return f;

	}*/
	
	@GetMapping(value ="/Moyennenote")
	@ResponseBody
	public float MoyenneNoteparuser() 
	{
			
	return feedBackService.topMoyenneuser();
		    
	}
	
	@GetMapping(value ="/Moyenne-paruser/{Id}")
	@ResponseBody
	public float Moyenne_user(@PathVariable("Id") Long Id) 
	{
			
	return feedBackService.Moyenne_user(Id);
		    
	}
}
