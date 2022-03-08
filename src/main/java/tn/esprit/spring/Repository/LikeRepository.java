package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Entity.Publication;

public interface LikeRepository extends CrudRepository<Likee, Integer>{
  
	
	
	
	//@Query(value="Select COUNT(nbrlike) FROM like  c  Where  c.nbrlike=1 ",nativeQuery = true)
	//int getNbrLikee2();

	//@Query(value="Select COUNT(nbrlike) FROM like c Where c.nbrlike=0",nativeQuery = true)
	//int getNbrLikee3();
	
}
