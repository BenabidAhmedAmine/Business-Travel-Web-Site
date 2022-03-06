package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Entity.Publication;

public interface LikeRepository extends CrudRepository<Likee, Integer>{
  
	
	
}
