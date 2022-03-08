package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Badge;
import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.ComplaintsRepository;
import tn.esprit.spring.Repository.DislikeRepository;
import tn.esprit.spring.Repository.FeedbackRepository;
import tn.esprit.spring.Repository.LikeeRepository;
import tn.esprit.spring.Repository.ProjectRepository;
import tn.esprit.spring.Repository.PublicationRepository;
import tn.esprit.spring.Repository.SubscriptionRepository;
import tn.esprit.spring.Repository.TravelRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ComplaintsRepository  complaintsRepository;
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	SubscriptionRepository  subscriptionRepository;
	@Autowired
	TravelRepository  travelRepository;
	@Autowired
	LikeeRepository   likeeRepository;
	@Autowired
	DislikeRepository   dislikeRepository;
	@Autowired
	PublicationRepository  publicationRepository;
	@Autowired
	ProjectRepository     projectRepository;
	

	@Override
	public Badge AffectBadge(Long idUser) {
		int scoreSub =calculSubcription(idUser);
		int scoreCom = nbrTravelsComparedWithComplaints(idUser);
		int scoreFeed = calculFeedback(idUser);
		int scorePub = nbrPubComparedWithSubscribersAndLikes(idUser);
		int scoreProj = calculProjet(idUser);
		int scoreTotal=scoreSub+scoreCom+scoreFeed+scorePub+scoreProj;
		
		if(scoreTotal<380){
			
			return Badge.Aucunbadge;
			
		}else if(scoreTotal>=380 && scoreTotal<=1000 ){
			
			return Badge.Bronze;
			
		}else if(scoreTotal>1000 && scoreTotal<=10000 ){
			return Badge.Silver;
			
		}else{
		
		return Badge.Gold;
		}
		
		
	}

	@Override
	public int calculSubcription(Long idUser) {
		//long id = user.getUserId(); 
		int nbrSub= subscriptionRepository.countSubscribers(idUser);
		if (nbrSub <=20){
			return 0;
			
		}else if(nbrSub > 20 && nbrSub <= 400){
			return nbrSub-20;
			
		}else{
			nbrSub-=20;
			int l1=nbrSub-380 ;
			return (nbrSub-l1)+(l1*5);
			
		}
	}

	
	@Override
	public int nbrTravelsComparedWithComplaints(Long idUser) {
		//long id = user.getUserId(); 
		int nbrComplaints= complaintsRepository.countComplaints(idUser);
		int nbrTravels= travelRepository.countTravels(idUser) ;
		
		if(nbrComplaints == 0 && nbrTravels==0 ){
			  return 0; }
		float prcComplaints= nbrComplaints/nbrTravels;    
		float fivePrcTravels=5*nbrTravels/100;
		float tenPrcTravels=10*nbrTravels/100;
		float twentyPrcTravels=20*nbrTravels/100;
		float fortyPrcTravels=40*nbrTravels/100;
		
		if (nbrComplaints == 0 || prcComplaints < fivePrcTravels){
			  
			  return nbrTravels*10;
			  
		  }else if( prcComplaints >= fivePrcTravels && prcComplaints < tenPrcTravels){
			  
			  return nbrTravels*5;
			  
		  }else if( prcComplaints >= tenPrcTravels && prcComplaints < twentyPrcTravels){
			  
			  return (nbrTravels/2)*5;
			  
		  }else if( prcComplaints >= twentyPrcTravels && prcComplaints < fortyPrcTravels){
			  
			  return nbrTravels;
			  
		  }else{
			  return 0;
		  }
			  
	}
	
	@Override
	public int nbrPubComparedWithSubscribersAndLikes(Long idUser) {
		Integer nbrLikes= likeeRepository.getNbrLikesOfPub(idUser);
		//int nbrDislikes= dislikeRepository.getNbrDislikesOfPub(idUser);
		int nbrPubs= publicationRepository.countPublications(idUser);
		int nbrSub= subscriptionRepository.countSubscribers(idUser);
		
          if(nbrPubs==0 || nbrSub==0){
			
			return 0;}
		
		float moyenLikeParPub =nbrLikes/nbrPubs;
		
		if((moyenLikeParPub/nbrSub)*100>=60){
			
			return nbrLikes*10;
			
		}else if((moyenLikeParPub/nbrSub)*100<60 && (moyenLikeParPub/nbrSub)*100>=40){
			
			return nbrLikes*5;
			
		}else if((moyenLikeParPub/nbrSub)*100<40 && (moyenLikeParPub/nbrSub)*100>=25){
			 return nbrLikes ;
			
		}else{
		
		return 0;}
	}

	@Override
	public int calculFeedback(Long idUser) {
		//long idUser = user.getUserId();
		Integer sommeNote = feedbackRepository.SommeNote1(idUser);
		 List<FeedBack> existing =feedbackRepository.FeedBackUserExist(idUser) ;
		
		if (existing.isEmpty()){
			return 0;
			
		}else if (sommeNote<100){
			return 0;
		
		}else{
			
			return sommeNote/10;
		}
		
		
	}
	
	@Override
	public int calculProjet(Long idUser) {
		int nbrProjets=projectRepository.countProject(idUser);
		
		if(nbrProjets==0){
			return 0;
		}else{
		    return nbrProjets*100;
		}
	}


	
	@Override
	public List<User> SearchEmployeesByName(String firstName,String lastName, String companyName) {
		
		List<User> lusers=userRepository.findEmployeesOfCompanyByname(firstName, lastName, companyName);
		return lusers ;
	}

	@Override
	public List<User> SearchEmployeesByProfession(String nameProfession, String companyName) {
		
		//String companyName= user.getCompanyName();
		List<User> lusers=userRepository.findEmployeesOfCompanyByProfessionsName(nameProfession,companyName);
		return lusers ;
	}


	@Override
	public List<User> getAllEmmployeesOfCompany(String companyName) {
		
		//String companyName= user.getCompanyName();
		List<User> lusers=userRepository.getAllEmployeesOfCompany(companyName);
		return lusers;
	}


	@Override
	public User getCompanyName(Long idUser) {
		 
		User currentUser=userRepository.findById(idUser).orElse(null);
		String companyName= currentUser.getCompanyName();
	
		return userRepository.getCompanyOfEmployee(companyName);
	}

	@Override
	public Integer getNbrLikesOfPub(Long idUser) {
		// TODO Auto-generated method stub
		return projectRepository.countProject(idUser);
	}





}
