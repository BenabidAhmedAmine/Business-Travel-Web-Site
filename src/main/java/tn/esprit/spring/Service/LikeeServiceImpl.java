package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Repository.LikeRepository;

@Service
public class LikeeServiceImpl implements ILikeService{
	@Autowired
	LikeRepository likeRepository;
	@Override
	public Likee addLikee(Likee likee) {
		
		return likeRepository.save(likee);
		
	}

}
