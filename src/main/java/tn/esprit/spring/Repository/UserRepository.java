package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.DomainActivity;
import tn.esprit.spring.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Long countBySubscriptionsUsersUserId(Long Id);
	List<User>findByFirstNameOrLastNameLike(String firstName, String lastName);
	List<User>findByDomainActivityName(String name);
	
	
	
}
