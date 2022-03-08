package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.StatusComplaints;

public interface IComplaintsService {
	//public void ajouterEtaffecterListecomplaints(List<Complaints> c, Long userId);

	List<Complaints> retrieveAllComplaints();

	Complaints addComplaints(Complaints c);

	void deleteComplaints(Long idComplaints);

	//Complaints updateComplaints(Complaints c);

	Optional<Complaints> retrieveComplaints(Long idComplaints);

	List<Complaints> getComplaintsByUser(Long Id);

	List<Complaints> listeDeComplaintsParStatus(StatusComplaints statusComplaints);
	//void ajouterEtAffecterComplaintsUser(List<Complaints> c,Long userId);



	List<Complaints> retrieveComplaintswithsorting(String field);

	

	void assignComplaintsToUser(long idComplaint, long Id);

	String ajouterEtaffectercomplaints(Complaints c, Long Id);

	boolean deleteComplaintsEmploye(Long idComplaints);

	Complaints updateComplaintsEmploye(Complaints c);
	//public void sendMail();

	Page<Complaints> findComplaintwithPagination(int offset, int pagesize);

	void sendSimpleEmail(String toAddress, String subject, String message);

	Complaints updateComplaints(Complaints c);

	int getnbrComplaintsByUser(Long Id);


	
}
