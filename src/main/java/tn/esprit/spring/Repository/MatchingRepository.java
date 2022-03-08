package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Matching;
import tn.esprit.spring.Entity.User;

@Repository
public interface MatchingRepository  extends JpaRepository<Matching, Integer>{
	
	
	
	//Matching findUser1AndUser2(User iduser1 ,User iduser2);
	Matching findByUser1AndUser2(User iduser1,User iduser2);

	Matching findByUser2AndUser1(User iduser2,User iduser1);

	
	//List<Matching> findByUser1(User user);
//	List<Matching> findByUser2(User user);
}
