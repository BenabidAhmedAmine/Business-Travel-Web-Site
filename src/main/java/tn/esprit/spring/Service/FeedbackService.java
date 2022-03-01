package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Repository.FeedbackRepository;


@Service
public class FeedbackService implements IFeedbackService{
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Override
	public List<FeedBack> retrieveAllFeedBacks() {
		// TODO Auto-generated method stub
		return (List<FeedBack>) feedbackRepository.findAll();
	}

	@Override
	public FeedBack addFeedBack(FeedBack c) {
		// TODO Auto-generated method stub
		
		return feedbackRepository.save(c);
	}

	@Override
	public void deleteFeedBack(Long idFeedBack) {
		 feedbackRepository.deleteById(idFeedBack);
	}


	@Override
	public FeedBack updateFeedBack(FeedBack c) {
	
		return feedbackRepository.save(c);
	}


	@Override
	public Optional<FeedBack> retrieveFeedBack(Long idFeedBack) {
		return feedbackRepository.findById((long) idFeedBack) ;
	}

}
