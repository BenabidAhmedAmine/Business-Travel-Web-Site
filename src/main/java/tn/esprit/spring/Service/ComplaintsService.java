package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.StatusComplaints;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.ComplaintsRepository;
import tn.esprit.spring.Repository.UserRepository;




@Service
public class ComplaintsService implements IComplaintsService{
	@Autowired
	ComplaintsRepository complaintsRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private MailSender sender;

    public void sendMail(long userId) {
    	User u = userRepository.findById(userId).orElse(null);
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("chedlikad@gmail.com");
        msg.setTo(u.getEmail());
        msg.setSubject("Champ de saisie du sujet");
        msg.setText("Champ de saisie du corps");

        this.sender.send(msg);
    }
	
	
	
	
	@Override
	public void ajouterEtaffectercomplaints(Complaints c, Long userId) {
		c.setStatusComplaints(StatusComplaints.Untreated);
		complaintsRepository.save(c);
		
		User user = userRepository.findById(userId).orElse(null);
		
			c.setUser(user);
			
		complaintsRepository.save(c);
	}

	
	@Override
	
	public void assignComplaintsToUser(long idComplaint, long userId) {
		Complaints c = complaintsRepository.findById(idComplaint).orElse(null);
		User u = userRepository.findById(userId).orElse(null);
		c.setUser(u);
		complaintsRepository.save(c);
	}
	
	@Override
	public Complaints addComplaints(Complaints c) {
		c.setStatusComplaints(StatusComplaints.Untreated);
		return complaintsRepository.save(c);
	}
	
	@Override
	public List<Complaints> retrieveComplaintswithsorting(String field) {
		return complaintsRepository.findAll(Sort.by(Sort.Direction.ASC,field)) ;
	}
	

	@Override
	public List<Complaints> retrieveAllComplaints() {
		return (List<Complaints>) complaintsRepository.findAll();
	}

	

	@Override
	public void deleteComplaints(Long idComplaints) {
		 complaintsRepository.deleteById(idComplaints);
	}

	
	@Override
	public Complaints updateComplaints(Complaints c) {
	Complaints complaints = complaintsRepository.findById(c.getIdComplaint()).orElse(null);
			complaints.setStatusComplaints(c.getStatusComplaints());
		return complaintsRepository.save(complaints);
	}

	@Override
	public Optional<Complaints> retrieveComplaints(Long idComplaints) {
		return complaintsRepository.findById((long) idComplaints) ;
	}
	

	@Override
	public List<Complaints> getComplaintsByUser(Long userId) {
		User user=userRepository.findById(userId).orElse(null);
		return complaintsRepository.findByUser(user);
	}
	
	public List<Complaints> listeDeComplaintsParStatus(StatusComplaints statusComplaints) {
		return complaintsRepository.findByStatusComplaints(statusComplaints);
	}

	
	@Override
	public boolean deleteComplaintsEmploye(Long idComplaints) {
		Complaints cm = complaintsRepository.findById(idComplaints).orElse(null);
		if(cm.getStatusComplaints()==StatusComplaints.Untreated) {
			complaintsRepository.delete(cm);
			return true;
		}
		return false;
	}

	
	@Override
	public Complaints updateComplaintsEmploye(Complaints c) {
	Complaints complaints = complaintsRepository.findById(c.getIdComplaint()).orElse(null);
	if(complaints.getStatusComplaints()==StatusComplaints.Untreated) {
			complaints.setMessage(c.getMessage());
			complaints.setObject(c.getObject());
		return complaintsRepository.save(complaints);
	}
	return null;
}
	
	@Scheduled(cron="*/30 * * * * *")
	public void nbreComplaintsByStatusComplaints(){
		int nbrUntreated=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.Untreated);
		int nbrInProgress=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.InProgress);
		int nbrTreated=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.Treated);
		System.out.println("nombre des Reclamation untreated:"+nbrUntreated);
		System.out.println("nombre des Reclamation InProgress:"+nbrInProgress);
		System.out.println("nombre des Reclamation treated:"+nbrTreated);
		
	}
	
	
	//private User user;
	//@Scheduled(cron="*/30 * * * * *")
	/*public void nbreClientParUser(){
		int nbruser=complaintsRepository.getComplaintsByUser(User.userId);
		System.out.println("nombre des Reclamation untreated:"+nbruser);
		
	}*/
}
	
	
	