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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Service.IFeedbackService;
@RestController
public class FeedBackController {
	@Autowired
	IFeedbackService feedBackService;
	
	@PostMapping("/add-feedBack")
	@ResponseBody
	FeedBack addFeedBack(@RequestBody FeedBack c){
	return feedBackService.addFeedBack(c);
	}

	
	@PutMapping("/modify-feedBack")
	@ResponseBody
	FeedBack updateFeedBack(@RequestBody FeedBack c){
		return feedBackService.updateFeedBack(c);
	}
	
	@DeleteMapping("/delete-feedBack/{idFeedBack}")
	void deleteFeedBack(@PathVariable(name="idFeedBack")Long idFeedBack){
		feedBackService.deleteFeedBack(idFeedBack);
	}

	@GetMapping("/retrieve-feedBack")
	@ResponseBody
	List<FeedBack> retrieveAllFeedBack(){
	return feedBackService.retrieveAllFeedBacks();
	}
	@GetMapping("/retrieve-id/{idFeedBack}")
	@ResponseBody
	Optional<FeedBack> retrieveComplaints(@PathVariable(name="idFeedBack")Long idFeedBack){
	return feedBackService.retrieveFeedBack(idFeedBack);
	}
	
}
