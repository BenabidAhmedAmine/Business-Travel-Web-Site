package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.LikeRepository;
import tn.esprit.spring.Repository.PublicationRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class LikeeServiceImpl implements ILikeService{
	@Autowired
	LikeRepository likeRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public Likee addLikee(Likee likee) {
		
		return likeRepository.save(likee);
		
	}
	@Override
	public void ajouterEtaffecterlike(Likee likee, Integer pubId) {
		Publication publication = publicationRepository.findById(pubId).orElse(null);
			
			likee.setPublication(publication);
			likeRepository.save(likee);
			}
	@Override
	public Likee updateLikee(Likee l) {
		return likeRepository.save(l);
	}
	@Override
	public void deleteLikee(Integer idlike) {
		likeRepository.deleteById(idlike);		
	}
	@Override
	public void ajouterEtaffecterlike(Likee likee, Integer pubId, Long Id) {
		Publication publication = publicationRepository.findById(pubId).orElse(null);
		User user = userRepository.findById(Id).orElse(null);
		likee.setPublication(publication);
		likee.setUser(user);

		likeRepository.save(likee);
	}
	
	
	//public String getNbrLikee4() {
		
		// String x="";
		 //if (likeRepository.getNbrLikee3()>likeRepository.getNbrLikee2()){
			// x="Users are not satisfied";
		// }else {
			// x="Users are satisfied";
	//	 }
		//return  x;
	//}
	
}
