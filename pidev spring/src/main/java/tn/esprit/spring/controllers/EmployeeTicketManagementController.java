package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.message.ResponseMessage;
import tn.esprit.spring.services.FileStorageService;
import tn.esprit.spring.services.ProjectService;
@RestController
@RequestMapping("/employeeTicketManagement")
public class EmployeeTicketManagementController {

	@Autowired
	  private FileStorageService storageService;
	@Autowired
	private ProjectService ps;
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	  @PostMapping("/assignFileToTicket/{idFile}/{idTicket}")
	  @ResponseBody
		public void assignFileToTicket(@PathVariable(value="idFile") String idFile,@PathVariable(value="idTicket") Long idTicket)
		{
			ps.assignFileToTicket(idFile, idTicket);
		}
}
