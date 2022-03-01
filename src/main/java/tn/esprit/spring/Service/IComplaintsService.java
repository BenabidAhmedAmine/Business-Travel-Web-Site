package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.StatusComplaints;

public interface IComplaintsService {
	//public void ajouterEtaffecterListecomplaints(List<Complaints> c, Long userId);

	List<Complaints> retrieveAllComplaints();

	Complaints addComplaints(Complaints c);

	void deleteComplaints(Long idComplaints);

	Complaints updateComplaints(Complaints c);

	Optional<Complaints> retrieveComplaints(Long idComplaints);

	List<Complaints> getComplaintsByUser(Long userId);

	List<Complaints> listeDeComplaintsParStatus(StatusComplaints statusComplaints);
	//void ajouterEtAffecterComplaintsUser(List<Complaints> c,Long userId);



	List<Complaints> retrieveComplaintswithsorting(String field);

	

	void assignComplaintsToUser(long idComplaint, long userId);

	void ajouterEtaffectercomplaints(Complaints c, Long userId);

	boolean deleteComplaintsEmploye(Long idComplaints);

	Complaints updateComplaintsEmploye(Complaints c);
    public void sendMail(long userId);




	
}
