package tn.esprit.spring.services;

import java.util.List;


import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Company;
import tn.esprit.spring.entities.Employee;
import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
import tn.esprit.spring.entities.Ticket;
@Service

public interface ProjectServiceImpl {
	
	List<Project> retrieveAllProjects();
    Project addProject(Project p);
    void deleteProject(Long id);
    Project updateProject(Project p);
    Project retrieveProject(Long id);
	public List<Project> byname(String nom);
	public List<Project> byDomain(String domaineActivite);
    public List<Project> byNbre(int nbreEmpDemande);
    Joining SendInvite(Joining j);
    List<Joining> retrieveAllInvitesByPrjectId(Long id);
    void assignInviteToProject(List<Joining> lj,Long prId);
    public List<User> perfectCompany(Long userId);
    List<Project> findPaginated(int pageNo, int pageSize, String sortBy);
	List<Joining> findAll();
	public void assignEmployeeToJoinings(Long idEmployee,Long idJoinings);
	//public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
	List<Employee> findPaginatedAndSortedEmployees(int pageNo, int pageSize, String sortBy);
    List<Employee> findemployeebycompanyidandsort(Long company_id);
   void addjoiningandassigntoemployees(Joining j,List<Long> idEmployees);
   void addTicketAndAssingToEmployee(Ticket t,Long idEmployee);
   void assignFileToTicket(String idFile, Long idTicket);
}
