package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Dislike;
@Repository
public interface DislikeRepository extends JpaRepository<Dislike, Integer> {
	
	
	//
	@Query("SELECT d.nbrdislike FROM Dislike d where (d.user.Id =:id)")
	public Integer getNbrDislikesOfPub(@Param ("id") Long id);

}
