package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Matching;
import tn.esprit.spring.Entity.User;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, Integer>{
	
	Matching findByUser1AndUser2(User iduser1,User iduser2);
	
	Matching findByUser2AndUser1(User iduser2,User iduser1);
	List<Matching> findByUser1(User user);
	List<Matching> findByUser2(User user);

	//Matching findByUser2Id(Long id);
	//Matching  findByUser2AndUser1(User iduser1,User iduser2);
	//@Query("select m  from Matching m  where ( m.user1.Id=:Id and m.user2.Id=:Id1)")
	//public Matching Matchingexist(@Param("Id") Long Id,@Param("Id1") Long Id1);
}
