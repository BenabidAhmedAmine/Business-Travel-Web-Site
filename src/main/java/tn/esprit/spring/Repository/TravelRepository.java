package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Travel;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {

	
	
	//
	@Query("SELECT count(*) FROM Travel t where (t.user.Id =:id)")
	public int countTravels(@Param ("id") Long id);
	
}
