package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.Matching;
import tn.esprit.spring.Entity.StatusComplaints;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.ComplaintsRepository;
import tn.esprit.spring.Repository.MatchingRepository;
import tn.esprit.spring.Repository.UserRepository;




@Service
public class ComplaintsService implements IComplaintsService{
	@Autowired
	ComplaintsRepository complaintsRepository;
	@Autowired
	MatchingRepository MR;
	@Autowired
	UserRepository userRepository;
	
	//@Autowired
    //private MailSender sender;

	 @Autowired
	 public JavaMailSender emailSender;
	private Matching mm;
	private Matching m;
	 
	 
	
	 public void sendSimpleEmail(String toAddress, String subject, String message) {
	  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	  simpleMailMessage.setTo(toAddress);
	  simpleMailMessage.setSubject(subject);
	  simpleMailMessage.setText(message);
	  emailSender.send(simpleMailMessage);
	 }

	
	
	
	@Override
	public String ajouterEtaffectercomplaints(Complaints c, Long Id) {
		List<Matching> lu1 = new ArrayList<Matching>();
		List<Matching> lu2 = new ArrayList<Matching>();
		User user = userRepository.findById((long) Id).orElse(null);
		User user2 =userRepository.findById(c.getToUser().getId()).orElse(null); 
		System.out.println("user2"+user2.getId());
		System.out.println("useer1"+user.getId());
		c.setStatusComplaints(StatusComplaints.Untreated);
		c.setUser(user);
		
		Matching M =MR.findByUser1AndUser2(user,user2);
		Matching M2=MR.findByUser2AndUser1(user, user2);
		if(M==null){
			if(M2.getMatchuser1().equals("yes") && M2.getMatchuser2().equals("yes")){
				
				complaintsRepository.save(c);
				return "Ajouter Avec Success";
			}else
				return "Ajout Impossible ";
		}
		else
		if(M2==null){
			if(M.getMatchuser1().equals("yes") && M.getMatchuser2().equals("yes")){
				
				complaintsRepository.save(c);
				return "Ajouter Avec Success";
			}else
				return "Ajout Impossible ";
		}
		else{
if(M.getMatchuser1().equals("yes") && M.getMatchuser2().equals("yes")){
				
				complaintsRepository.save(c);
				return "Ajouter Avec Success";
			}else
				return "Ajout Impossible ";
		}
	
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
	@Scheduled(cron="*/15 * * * * *")
	public void SommeComplaints() {
		int nbruser=complaintsRepository.SommeComplaint();
		System.out.println("n:"+nbruser);
		
	}
	
	
	
}	
	