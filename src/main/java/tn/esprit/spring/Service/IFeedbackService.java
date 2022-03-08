package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.FeedBack;

public interface IFeedbackService {


	void ajouterEtaffecterrFeedBack(FeedBack f, Long Id);
	
	List<FeedBack> retrieveAllFeedBacks();
	
	void deleteFeedBack(Long idFeedBack);
	
	Optional<FeedBack> retrieveFeedBack(Long idFeedBack);

	String updateFeedBack(Long idFeedBack, int note);

	List<FeedBack> listLastReviews();

	int nbReview(Long Id);

	float SommeNote(Long Id);


	
	public Optional<FeedBack> getfeedbackById(Long Id);

	Long topMoyenneuser();

	float Moyenne_user(Long Id);

	List<FeedBack> retrieveFeedBackwithsorting(String field);

	
}
