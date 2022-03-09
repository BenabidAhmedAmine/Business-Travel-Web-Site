package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itextpdf.text.DocumentException;
import com.sipios.springsearch.anotation.SearchSpec;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.var;
import tn.esprit.spring.configuration.GeneratePdfReport;

import tn.esprit.spring.entities.Employee;

import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.message.ResponseMessage;
import tn.esprit.spring.repositories.EmployeeRepository;
import tn.esprit.spring.repositories.ProjectRepository;

import tn.esprit.spring.services.ProjectService;


@RestController

@RequestMapping("/project")
public class ProjectController {
	
		@Autowired
		ProjectService ps;
		@Autowired
		ProjectRepository pr;
		@Autowired
		EmployeeRepository er;
		
		
		//findBy
		@GetMapping("/ByName/{nom}")
		public List<Project> byname(@PathVariable(value="nom") String nom)
		{return ps.byname(nom);}
		
		@GetMapping("/ByDomain/{domaineActivite}")
		public List<Project> byDomain(@PathVariable(value="domaineActivite") String domaineActivite)
		{return ps.byDomain(domaineActivite);}
		
		@GetMapping("/ByNbre/{nbreEmpDemande}")
		public List<Project> byNbre(@PathVariable(value="nbreEmpDemande") int nbreEmpDemande)
		{return ps.byNbre(nbreEmpDemande);}
		@GetMapping("/projects/nomanddomaoneactivite/{nom}/{domaineActivite}")
		public List<Project>  getProjectByNomAndDomaineActivite(@PathVariable (value="nom") String nom,@PathVariable (value="domaineActivite") String domaineActivite)
		{return pr.findByNomAndDomaineActivite(nom, domaineActivite);}
		@GetMapping("/projects/ByNomOrDomaineActiviteOrNbreEmpDemande/{nom}/{domaineActivite}/{nbreEmpDemande}")
		public List<Project> getProjectByNomOrDomaineActiviteOrNbreEmpDemande(@RequestParam (value="nom") String nom,@RequestParam (value="domaineActivite") String domaineActivite,@RequestParam(value="nbreEmpDemande") int nbreEmpDemande) {
			return pr.findByNomOrDomaineActiviteOrNbreEmpDemande(nom, domaineActivite, nbreEmpDemande);
		}
		@GetMapping("/invite-list/{id}")
		public List<Joining> findInvByPrId(@PathVariable(value="id") Long id)
		{return ps.retrieveAllInvitesByPrjectId(id);}
		@GetMapping("/projects/{pageNo}/{pageSize}/{sortBy}")
	    public List<Project> getPaginatedProjects(@PathVariable int pageNo, 
	            @PathVariable int pageSize,@PathVariable String sortBy) {

	        return ps.findPaginated(pageNo, pageSize, sortBy);
	    }
		//Crud
		@GetMapping("/retrieve-all-projects")
		@ResponseBody
		public List<Project> getProjects() {
			List<Project> listProjects = ps.retrieveAllProjects();
			return listProjects;}
		
		
		@GetMapping("/retrieve-project/{project-id}")
		@ResponseBody
		public Project retrieveProject(@PathVariable("project-id") Long projectId) {
		return ps.retrieveProject(projectId);
		}
		
		
		@PostMapping("/add-project")
		@RequestBody
		public Project addProject(@RequestBody Project p)
		{
			Project project = ps.addProject(p);
		return project;
		}
		
		
		@DeleteMapping("/remove-project/{project-id}")
		@ResponseBody
		public void removeProject(@PathVariable("project-id") Long projectId) {
		ps.deleteProject(projectId);
		}
		
		@PutMapping("/modify-project")
		@ResponseBody
		public Project modifyProject(@RequestBody Project project) {
		return ps.updateProject(project);
		}
		//Others
		@PostMapping(value = "/assigninvitetoproject/{prId}") 
		public void assignInviteToProject(@RequestParam List<Joining> lj, @PathVariable("prId")Long prId) {
			ps.assignInviteToProject(lj, prId);
		}
		@PostMapping(value = "/assignepmloyeetojoining/{idEmployee}/{idJoinings}") 
		public void assignEmployeeToJoining(@PathVariable("idEmployee")Long idEmployee,@PathVariable("idJoinings")Long idJoinings) {
			ps.assignEmployeeToJoinings(idEmployee, idJoinings);
		}
		@GetMapping("/projects/average/{company_id}")
		public float average(@PathVariable("company_id") Long company_id)
		{return er.average(company_id);}
		@GetMapping("/projects/{project_id}")
		public String pr(@PathVariable("project_id") Long project_id)
		{
			return er.pr(project_id);
		}
		 
         //pdf
		 @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
		            produces = MediaType.APPLICATION_PDF_VALUE)
		    public ResponseEntity<InputStreamResource> joiningsReport() {

		        var joinings = (List<Joining>) ps.findAll();

		        ByteArrayInputStream bis = GeneratePdfReport.joiningsReport(joinings);

		        var headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename=joiningsreport.pdf");

		        return ResponseEntity
		                .ok()
		                .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
		 //file
		 
		 

	}



