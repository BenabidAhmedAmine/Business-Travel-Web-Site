package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	
	
	
	//
	@Query("SELECT count(*) FROM Subscription s where (s.userr.Id =:id)")
	public int countSubscribers(@Param ("id") Long id);
	
	

}
