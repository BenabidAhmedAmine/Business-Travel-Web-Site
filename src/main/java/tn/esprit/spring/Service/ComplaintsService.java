package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	//@Autowired
    //private MailSender sender;

	 //@Autowired
	 //public JavaMailSender emailSender;
	 
	 
	
	// public void sendSimpleEmail(String toAddress, String subject, String message) {
	 // SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	 // simpleMailMessage.setTo(toAddress);
	 // simpleMailMessage.setSubject(subject);
	 // simpleMailMessage.setText(message);
	 // emailSender.send(simpleMailMessage);
	 //}

	
	
	
	@Override
	public void ajouterEtaffectercomplaints(Complaints c, Long Id) {
		c.setStatusComplaints(StatusComplaints.Untreated);
		complaintsRepository.save(c);
		
		User user = userRepository.findById(Id).orElse(null);
		
			c.setUser(user);
			
		complaintsRepository.save(c);
	}

	
	@Override
	
	public void assignComplaintsToUser(long idComplaint, long Id) {
		Complaints c = complaintsRepository.findById(idComplaint).orElse(null);
		User u = userRepository.findById(Id).orElse(null);
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
		//User u = userRepository.findById(userId).orElse(null);
	Complaints complaints = complaintsRepository.findById(c.getIdComplaint()).orElse(null);
			complaints.setStatusComplaints(c.getStatusComplaints());
			if(c.getStatusComplaints()==StatusComplaints.Treated){
			sendSimpleEmail(complaints.getToUser().getEmail(), "Avertissement", "Une reclamation à étè déposée en toi, veuillez etre responsable");
			return complaintsRepository.save(complaints);}
			sendSimpleEmail(complaints.getUser().getEmail(), "InProgress", "votre reclamation est en cour de traitement");
			return complaintsRepository.save(complaints);
	}

	@Override
	public Optional<Complaints> retrieveComplaints(Long idComplaints) {
		return complaintsRepository.findById((long) idComplaints) ;
	}
	

	@Override
	public List<Complaints> getComplaintsByUser(Long Id) {
		User user=userRepository.findById(Id).orElse(null);
		return complaintsRepository.findByToUser(user);
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
	
	public Page<Complaints> findComplaintwithPagination(int offset,int pagesize ){ 
		Page<Complaints> com=	complaintsRepository.findAll(PageRequest.of(offset, pagesize));
		return com;
	}
	
	@Override
	public int getnbrComplaintsByUser(Long Id) {
		return complaintsRepository.getnbrComplaintsByUser(Id);
	}
	
	@Scheduled(cron="*/100 * * * * *")//30
	public void nbreComplaintsByStatusComplaints(){
		int nbrUntreated=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.Untreated);
		int nbrInProgress=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.InProgress);
		int nbrTreated=complaintsRepository.getComplaintsByStatusComplaints(StatusComplaints.Treated);
		System.out.println("nombre des Reclamation untreated:"+nbrUntreated);
		System.out.println("nombre des Reclamation InProgress:"+nbrInProgress);
		System.out.println("nombre des Reclamation treated:"+nbrTreated);
		
	}

	//private User user;
	@Scheduled(cron="*/100 * * * * *")//15
	public void SommeComplaints() {
		int nbruser=complaintsRepository.SommeComplaint();
		System.out.println("n:"+nbruser);
		
	}


	@Override
	public void sendSimpleEmail(String toAddress, String subject, String message) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}	
	