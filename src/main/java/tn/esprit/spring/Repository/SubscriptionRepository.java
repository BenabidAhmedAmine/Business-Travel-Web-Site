package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Etat;
import tn.esprit.spring.Entity.Subscription;
import tn.esprit.spring.Entity.User;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>  {

	Optional<Subscription> findByTitle(String title);
public List<Subscription> findByEtat(Etat etat);

	

@Query("select count(c) from Subscription c where c.etat=:etat")
int getsubscriptionByEtat(@Param("etat") Etat etat);
List<Subscription> findByUser(User user);
List<Subscription> findByUserr(User user);
	

}
