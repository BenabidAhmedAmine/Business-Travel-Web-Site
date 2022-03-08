package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Badge;
import tn.esprit.spring.Entity.User;

public interface IUserService {
	
	public List<User> getAllEmmployeesOfCompany(String companyName);
	
	public List<User> SearchEmployeesByName(String firstName,String lastName, String companyName);
	
	public List<User> SearchEmployeesByProfession(String nameProfession, String companyName);
	
	public User getCompanyName(Long idUser);
	
	
	//calcul badge
	public Badge AffectBadge(Long idUser);
	
	public int nbrTravelsComparedWithComplaints(Long idUser);
	
	public int nbrPubComparedWithSubscribersAndLikes(Long idUser);
	
	public int calculFeedback(Long idUser);
	
	public int calculSubcription(Long idUser);
	
	public int calculProjet(Long idUser);
	
	public Integer getNbrLikesOfPub(Long idUser);
	
	
	

}
