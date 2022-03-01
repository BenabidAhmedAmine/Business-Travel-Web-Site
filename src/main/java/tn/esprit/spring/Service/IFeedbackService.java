package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.FeedBack;

public interface IFeedbackService {

	List<FeedBack> retrieveAllFeedBacks();

	FeedBack addFeedBack(FeedBack c);

	void deleteFeedBack(Long idFeedBack);

	FeedBack updateFeedBack(FeedBack c);

	Optional<FeedBack> retrieveFeedBack(Long idFeedBack);

}
