package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Dislike;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.DislikeRepository;
import tn.esprit.spring.Repository.PublicationRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class DislikeServiceImpl  implements IDislikeService {

	@Autowired
	PublicationRepository publicationRepository;
	
	@Autowired
	DislikeRepository dislikeRepository;
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Dislike addDislike(Dislike dislike) {
		return dislikeRepository.save(dislike);
	}

	@Override
	public void ajouterEtaffecterdislike(Dislike d, Integer pubId) {
		Publication publication = publicationRepository.findById(pubId).orElse(null);
		
		d.setPublication(publication);
		dislikeRepository.save(d);
		}

	@Override
	public void deleteDislike(Integer iddislike) {
		dislikeRepository.deleteById(iddislike);		
		
	}

	@Override
	public void ajouterEtaffecterlike(Dislike d, Integer pubId, Long Id) {
		Publication publication = publicationRepository.findById(pubId).orElse(null);
		User user = userRepository.findById(Id).orElse(null);
		d.setPublication(publication);
		d.setUser(user);

		dislikeRepository.save(d);
	}

}
