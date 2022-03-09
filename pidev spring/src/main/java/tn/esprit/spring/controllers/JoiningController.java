package tn.esprit.spring.controllers;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entities.Company;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.repositories.CompanyRepository;
import tn.esprit.spring.repositories.EmployeeRepository;
import tn.esprit.spring.repositories.Employeesortrepository;
import tn.esprit.spring.repositories.JoiningRepository;
import tn.esprit.spring.repositories.TicketRepository;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.services.ProjectService;

@RestController
@RequestMapping("/invites")
public class JoiningController {
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

//	@GetMapping("/empl-list")
//	public List<Employee> ordered()
//	{return er.findTop2ByOrderByNoteDesc();}
	@GetMapping("/employees/{pageNo}/{pageSize}/{sortBy}")
    public List<Employee> getPaginatedEmployees(@PathVariable int pageNo, 
            @PathVariable int pageSize,@PathVariable String sortBy) {

        return ps.findPaginatedAndSortedEmployees(pageNo, pageSize, sortBy);
    }
	@PostMapping("/send-Invite")
	@ResponseBody
	@RequestBody
	public Joining SendInvite(@RequestBody Joining j)
	{
		Joining joining = ps.SendInvite(j);
	return joining;
	}
	@PostMapping("/send-Invite-andassign-to-empl")
	@ResponseBody
	public void SendInviteand(@RequestBody Joining j,@RequestParam(value="idEmployees") List<Long> idEmployees)
	{
		ps.addjoiningandassigntoemployees(j, idEmployees);
	}
	@GetMapping("/employees")
    public List<Employee> getEmployees() {

        return er.findTop2ByOrderByNoteDesc();
    }
//	@GetMapping("/employeesbycompid/{company_id}")
//    public List<Employee> getEmployeesbycompid(@PathVariable("company_id") Long company_id) {
//
//        return er.emplbycomid(company_id);
//    }
	@GetMapping("/employeesbycompid/{company_id}")
    public List<Employee> getEmployeesbycompidandsorted(@PathVariable("company_id") Long company_id) {

        return ps.findemployeebycompanyidandsort(company_id);
    }
	@GetMapping("/compandavg")
    public List<Object[]> compandavg() {

        return er.companyandheravg();
    }
//    @GetMapping("/all-invites-by-id")
//    public List<Object[]> compandavg() {
//
//        return er.companyandheravg();
//    }
    //email
    

    

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

    @GetMapping(value = "/simple-order-email/{user-email}")
    public @ResponseBody ResponseEntity sendEmailAttachment(@PathVariable("user-email") String email) {

        try {
            emailService.sendEmailWithAttachment(email, "Order Confirmation", "Thanks for your recent order",
                    "classpath:purchase_order.pdf");
        } catch (MessagingException | FileNotFoundException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox for order confirmation", HttpStatus.OK);
    }
    @GetMapping(value = "/simple-email/")
    public @ResponseBody ResponseEntity sendComplaint(String email) {

        try {
        	
            emailService.sendSimpleEmail(email, "Welcome", "This is a welcome email for your!!");
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }
    @GetMapping("/alert")
    public List<Object[]> alert() {

        return tr.alert();
    }
	
}
