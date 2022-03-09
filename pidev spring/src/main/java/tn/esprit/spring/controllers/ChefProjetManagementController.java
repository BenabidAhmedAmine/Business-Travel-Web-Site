package tn.esprit.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Ticket;
import tn.esprit.spring.message.ResponseFile;
import tn.esprit.spring.repositories.CompanyRepository;
import tn.esprit.spring.repositories.EmployeeRepository;
import tn.esprit.spring.repositories.Employeesortrepository;
import tn.esprit.spring.repositories.JoiningRepository;
import tn.esprit.spring.repositories.TicketRepository;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.services.FileStorageService;
import tn.esprit.spring.services.ProjectService;
@RestController
@RequestMapping("/ChefDeProjet")
public class ChefProjetManagementController {
	
	@Autowired
	  private FileStorageService storageService;
	@Autowired
	private ProjectService ps;
	@Autowired
	private CompanyRepository cr;
	@Autowired
	private EmployeeRepository er;
	@Autowired
	private JoiningRepository jr;
	@Autowired
	private Employeesortrepository esr;
	@Autowired
    EmailService emailService;
	@Autowired
	private TicketRepository tr;
    private static final Logger LOG = LoggerFactory.getLogger(JoiningController.class);

	
	@GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();
	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDB fileDB = storageService.getFile(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  @PostMapping("/addticketandassigntoemployee/{idEmployee}")
	  @ResponseBody
		public void addticketandassigntoemployee(@RequestBody Ticket t,@PathVariable(value="idEmployee") Long idEmployee)
		{
			ps.addTicketAndAssingToEmployee(t, idEmployee);
		}
	  @GetMapping("/alert")
	    public List<Object[]> alert() {

	        return tr.alert();
	    }
	    @GetMapping("/nonremis")
	    public List<Object[]> nonremis() {

	        return tr.nonremis();
	    }
	    @GetMapping(value = "/simple-email/{user-email}")
	    public @ResponseBody ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email) {

	        try {
	            emailService.sendSimpleEmail(email, "Hurry up", "you have one more day to put your work. put now?! uploadfile here: http://localhost:8083/project/employeeTicketManagement/upload then assign it to your ticket here :http://localhost:8083/project/employeeTicketManagement/assignFileToTicket/{fileid}/{yourticketid}\r\n"
	            		+ " ");
	        } catch (MailException mailException) {
	            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
	            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
	    }
}
