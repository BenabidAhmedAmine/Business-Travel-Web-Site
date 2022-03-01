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

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.StatusComplaints;
import tn.esprit.spring.Service.IComplaintsService;





@RestController
public class ComplaintsController {
	@Autowired
	IComplaintsService complaintService;
	
	
	@PostMapping("/ajouterEtaffectercomplaints/{userId}")
	@ResponseBody
	public void  ajouterEtaffectercomplaints(@RequestBody Complaints c, @PathVariable("userId") long userId) {
		 complaintService.ajouterEtaffectercomplaints(c, userId);
	}
	
	
	@PutMapping("/modify-complaint")
	@ResponseBody
	Complaints updateComplaints(@RequestBody Complaints c){
		return complaintService.updateComplaints(c);
	}
	
	@DeleteMapping("/delete-complaint/{idComplaints}")
	void deleteComplaints(@PathVariable(name="idComplaints")Long idComplaints){
		complaintService.deleteComplaints(idComplaints);
	}

	@GetMapping("/retrieve-complaint")
	@ResponseBody
	List<Complaints> retrieveAllComplaints(){
	return complaintService.retrieveAllComplaints();
	}
	
	/*@GetMapping("/retrieve-id/{idComplaints}")
	@ResponseBody
	Optional<Complaints> retrieveComplaints(@PathVariable(name="idComplaints")Long idComplaints){
	return complaintService.retrieveComplaints(idComplaints);
	}*/
	
	@GetMapping("/AfficherComplaintStatus/{statusComplaints}")
	@ResponseBody
	 List<Complaints> AfficherComplaintsParStatus(@PathVariable("statusComplaints")StatusComplaints statusComplaints) {
		return complaintService.listeDeComplaintsParStatus(statusComplaints);
	}
	@PostMapping("/mail/{userId}")
	@ResponseBody
	public void sendMail( @PathVariable("userId") long userId) {
		complaintService.sendMail(userId);
	}
	
	@GetMapping("/listeComplaints/{userId}")
	@ResponseBody
	 List<Complaints> getComplaintsByUser(@PathVariable("userId") Long userId) {
		return complaintService.getComplaintsByUser(userId);
	}
	
	@GetMapping("/{field}")
	@ResponseBody
	List<Complaints> retrieveComplaintswithsorting(@PathVariable("field") String field){
	return complaintService.retrieveComplaintswithsorting(field);
	}
	
	
	
	@DeleteMapping("/delete-c/{idComplaints}")
	void delete(@PathVariable(name="idComplaints")Long idComplaints){
		complaintService.deleteComplaintsEmploye(idComplaints);
	}
	

	@PutMapping("/modify-c")
	@ResponseBody
	Complaints updateEmploye(@RequestBody Complaints c){
		return complaintService.updateComplaintsEmploye(c);
	}
}



