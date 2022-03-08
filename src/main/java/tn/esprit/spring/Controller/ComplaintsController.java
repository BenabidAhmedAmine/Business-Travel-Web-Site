package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
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
	
	
	@PostMapping("/ajouterEtaffectercomplaints/{Id}")
	@ResponseBody
	public String  ajouterEtaffectercomplaints(@RequestBody Complaints c, @PathVariable("Id") long Id) {
		 return complaintService.ajouterEtaffectercomplaints(c, Id);
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
	/*@PostMapping("/mail/{Id}")
	//@ResponseBody
	public void sendMail( @PathVariable("Id") long Id) {
		complaintService.sendMail(Id);
	}*/
	
	/*@PutMapping("/mail")
	@ResponseBody
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(@RequestBody String toEmail) {
		complaintService.sendMail(toEmail);
	}*/
	
	@GetMapping("/listeComplaints/{Id}")
	@ResponseBody
	 List<Complaints> getComplaintsByUser(@PathVariable("Id") Long Id) {
		return complaintService.getComplaintsByUser(Id);
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
	
	@GetMapping("/find-Complaintwithpagination/{offset}/{pagesize}")
	@ResponseBody
	public Page<Complaints> findComplaintwithPagination(@PathVariable ("offset")int offset,@PathVariable("pagesize")int pagesize ){
		return complaintService.findComplaintwithPagination(offset, pagesize);
		
	}
	
	@GetMapping("/nbr-complaint-par-user/{Id}")
	@ResponseBody
	int nbrComplaintsparuser(@PathVariable(name="Id")Long Id){
		return complaintService.getnbrComplaintsByUser(Id);
	}
}



