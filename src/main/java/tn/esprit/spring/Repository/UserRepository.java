package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Dislike;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Entity.Subscription;
import tn.esprit.spring.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}

