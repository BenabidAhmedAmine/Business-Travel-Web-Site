package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.SystemInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Company;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.entities.Ticket;
import tn.esprit.spring.repositories.CompanyRepository;
import tn.esprit.spring.repositories.EmployeeRepository;
import tn.esprit.spring.repositories.Employeesortrepository;
import tn.esprit.spring.repositories.FileDBRepository;
import tn.esprit.spring.repositories.JoiningRepository;
import tn.esprit.spring.repositories.ProjectRepository;
import tn.esprit.spring.repositories.ProojectPaginationRepository;
import tn.esprit.spring.repositories.TicketRepository;
import tn.esprit.spring.repositories.UserRepository;


@Service

public class ProjectService  implements ProjectServiceImpl {

	@Autowired
	private ProjectRepository pr;
    @Autowired
    private JoiningRepository jr;
    @Autowired
    private UserRepository ur;
    @Autowired
    private ProojectPaginationRepository ppr;
    @Autowired
    private EmployeeRepository er;
    @Autowired
    private CompanyRepository cr;
    @Autowired
	private Employeesortrepository esr;
    @Autowired
    private TicketRepository tr;
    @Autowired
    private FileDBRepository fr;

	@Override
	public List<Project> retrieveAllProjects() {
		
		return (List<Project>) pr.findAll();
	}

	@Override
	public Project addProject(Project p) {
		return pr.save(p);
	}

	@Override
	public void deleteProject(Long id) {
		pr.deleteById(id);
		
	}

	@Override
	public Project updateProject(Project p) {
		
		return pr.save(p);
	}

	@Override
	public Project retrieveProject(Long id) {
		return pr.findById(id).orElse(null);
	}

	@Override
	public List<Project> byname(String nom) {
		return pr.findByNom(nom);
	}

	@Override
	public List<Project> byDomain(String domaineActivite) {
		
		return pr.findByDomaineActivite(domaineActivite);
	}

	@Override
	public List<Project> byNbre(int nbreEmpDemande) {
		return pr.findByNbreEmpDemande(nbreEmpDemande);
	}

	@Override
	public Joining SendInvite(Joining j) {
		
		return jr.save(j);
	}

	@Override
	public List<Joining> retrieveAllInvitesByPrjectId(Long id) {
		Project project = pr.findById(id).orElse(null);
		return jr.findByProject(project);
	}

	

	@Override
	public void assignInviteToProject(List<Joining> lj, Long prId) {
		Project project = pr.findById(prId).get();
		for (Joining joining : lj)
		{
			joining.setProject(project);
		}
		jr.saveAll(lj);
		
		
	}

	@Override
	public List<User> perfectCompany(Long userId) {
		User user = ur.findById(userId).get();
		
		return null;
	}

	@Override
	public List<Project> findPaginated(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
        Page<Project> pagedResult = ppr.findAll(paging);

        return pagedResult.toList();
	}

	@Override
	public List<Joining> findAll() {
		return (List<Joining>) jr.findAll();
	}

	@Override
	public void assignEmployeeToJoinings(Long idEmployee, Long idJoinings) {
		Employee employee = er.findById(idEmployee).get();
		Joining joining = jr.findById(idJoinings).get();
		
		employee.getJoinings().add(joining);
		er.save(employee);
		
	}
	

	@Override
	public List<Employee> findPaginatedAndSortedEmployees(int pageNo, int pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
        Page<Employee> pagedResult = esr.findAll(paging);

        return pagedResult.toList();
	}

	@Override
	public List<Employee> findemployeebycompanyidandsort(Long company_id) {
		List<Employee> employee = er.emplbycomid(company_id);
		for (Employee employ : employee)
		{
			return er.findTop2ByOrderByNoteDesc();	
		}
		return er.findTop2ByOrderByNoteDesc();	
		
	}

	@Override
	public void addjoiningandassigntoemployees(Joining j, List<Long> idEmployees) {
		jr.save(j);
		List<Employee> employees = (List<Employee>) er.findAll();
		for(Long id : idEmployees)
		{Employee e =er.findById(id).orElse(null);
		e.getJoinings().add(j);
		jr.save(j);
		}
		
	}

	@Override
	public void addTicketAndAssingToEmployee(Ticket t, Long idEmployee) {
		tr.save(t);
		Employee employee = er.findById(idEmployee).get();
        t.setEmployee(employee);
        tr.save(t);
	}

	@Override
	public void assignFileToTicket(String idFile, Long idTicket) {
		FileDB fileDB = fr.findById(idFile).get();
		Ticket ticket = tr.findById(idTicket).get();
		ticket.setFileDB(fileDB);
		tr.save(ticket);
		
	}

	
	

	

	

	
		
		
		
		
	}

	

	
	
	
	

