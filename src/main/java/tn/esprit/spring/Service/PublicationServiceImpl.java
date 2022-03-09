package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import tn.esprit.spring.Repository.PublicationRepository;
import tn.esprit.spring.Repository.SubscriptionRepository;
import tn.esprit.spring.Repository.UserRepository;

import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Entity.Subscription;

@Service
public class PublicationServiceImpl implements IPublicationService {

	@Autowired
	PublicationRepository publicationRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	UserRepository userRepository;



	

	@Override
	public List<Publication> retrieveAllPublications() {
		return (List<Publication>) publicationRepository.findAll();
	
	}

	
	

	@Override
	public Publication addPublication(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public Publication updatePublication(Publication publication) {
		return publicationRepository.save(publication);
	}
	
		

	@Override
	public Optional<Publication> retrieveUserById(long pubId) {
		// TODO Auto-generated method stub
		return null;
	}

	




	@Override
	public void deletePublication(Integer pubId) {
		publicationRepository.deleteById(pubId);
		
	}




	//@Override
	//public List<Publication> findByContents(String contents) {
	//	return (List<Publication>) publicationRepository.findByContents(contents);
//	}




	@Override
	public List<Publication> findByLastPublication(Date datePub, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Publication> findAllpublicationtri() {
		return  publicationRepository.findAllpublicationtri();
	}




	@Override
	public List<Publication> retrieveallPUblicationstriee(String pub) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
//	public List<Publication> getPublicationByUser(Long Id) {
	//	User user=userRepository.findById(Id).orElse(null);
		//return publicationRepository.findByUser(user);
	//}


	@Override
	public void ajouterEtaffecterListePublication(Publication publication, Long Id) {
		
	       User User = userRepository.findById(Id).orElse(null);
		
		publication.setUser(User);
		publicationRepository.save(publication);
	}

	@Override
	public List<Publication> retrievePublicationByUser(Long id){
		User user = userRepository.findById(id).orElse(null);
		System.out.println(user);
		//return publicationRepository.findByUserSubscriptionsUserr(user);
		 List<Publication> L1 =publicationRepository.findByUser(user);
		// List<User> U =userRepository.findByUser(user);

		 
		 List<Subscription> S= subscriptionRepository.findByUserr(user);
		 List<Publication> Final = new ArrayList<Publication>();
	
		 for(Publication P:L1){
			 for(Subscription LS:S){
				 if(P.getUser()==LS.getUserr() ){
					 Final.add(P);
				 }
						
			 }
			 	 }
		 return Final;
	}

}









//User user = userRepository.findById(id).orElse(null);
//System.out.println(user);
//return publicationRepository.findByUserSubscriptionsUserr(user);
 //List<Publication> L1 =publicationRepository.findByUser(user);
 
 //List<Subscription> S= subscriptionRepository.findByUser(user);
 
 //List<Publication> Final = new ArrayList<Publication>();
 //for(Subscription LS:S){
	 //for(Publication P:L1){
	//	 if(P.getUser()==LS.getUserr()){
			// Final.add(P);
		// }
				
	 //}
	// 	 }
 //return Final;
//}

//}