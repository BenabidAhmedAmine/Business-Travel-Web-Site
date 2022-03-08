package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.FeedbackRepository;
import tn.esprit.spring.Repository.UserRepository;


@Service
public class FeedbackService implements IFeedbackService{
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	UserRepository userRepository;
	private FeedBack fd;
	
	@Override
	public List<FeedBack> retrieveAllFeedBacks() {
		return (List<FeedBack>) feedbackRepository.findAll();
	}

	
		@Override
	public void ajouterEtaffecterrFeedBack(FeedBack f, Long Id) {
			fd = feedbackRepository.FeedBackexist(Id,f.getToUser().getId());
			if (fd==null){
				if (f.getNote()<100){
				User user = userRepository.findById(Id).orElse(null);
				
				f.setUser(user);
				
				f.setDateFeedback(new Date());
				f.setReview(f.getReview());
				f.setNote(f.getNote());
				f.setToUser(f.getToUser());
				feedbackRepository.save(f);
			
			}
				else System.out.println("Veuillez choisir une note entre 0 et 100 ");
			}
		}
	
		@Override
		public List<FeedBack> retrieveFeedBackwithsorting(String field) {
			return feedbackRepository.findAll(Sort.by(Sort.Direction.ASC,field)) ;
		}

	@Override
	public void deleteFeedBack(Long idFeedBack) {
		 feedbackRepository.deleteById(idFeedBack);
	}


	@Override
	public String updateFeedBack(Long idFeedBack, int note) {
		FeedBack feedBack = new FeedBack();

		feedBack = feedbackRepository.findById(idFeedBack).get();
		if (note<100){
		feedBack.setNote(note);

		feedBack.setDateFeedback(new Date());
		feedbackRepository.save(feedBack);

		return "note enregistré";	}
		else return "Veuillez choisir une note entre 0 et 100 ";
	}



	@Override
	public Optional<FeedBack> retrieveFeedBack(Long idFeedBack) {
		return feedbackRepository.findById((long) idFeedBack) ;
	}
	
	@Override
	public List<FeedBack> listLastReviews() {
		return feedbackRepository.listLastReviews();
	}
	@Override
	public int nbReview(Long Id) {
		return feedbackRepository.nbreviews(Id);
	}
	
	
	@Override
	public float SommeNote(Long Id) {

		return feedbackRepository.SommeNote(Id);}

	

	@Override
	public Long topMoyenneuser() {
		return feedbackRepository.top_MOYENNE_user();
	}
	@Override
	public float Moyenne_user(Long Id) {
		return feedbackRepository.Moyenne_user(Id);
	}
	
	
	
	@Override
	public Optional<FeedBack> getfeedbackById(Long Id) {
		return feedbackRepository.findById(Id);
	}
}
