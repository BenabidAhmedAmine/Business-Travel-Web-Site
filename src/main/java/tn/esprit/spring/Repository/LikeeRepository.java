package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Likee;
@Repository
public interface LikeeRepository extends JpaRepository<Likee, Integer>{
	
	
	//
	@Query("SELECT SUM(l.nbrlike) FROM Likee l where (l.user.Id =:id)")
	public Integer getNbrLikesOfPub(@Param ("id") Long id);

}
