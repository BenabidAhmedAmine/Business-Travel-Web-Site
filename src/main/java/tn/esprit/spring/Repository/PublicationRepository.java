package tn.esprit.spring.Repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Etat;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Entity.User;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {
	//public List<Publication> findByContents(String contents);
	//public Page<Publication> findByContents(String contents,Pageable pageable);
	
	
	
	
	@Query(value= "select * from publication  order by date_Pub desc",nativeQuery = true)
	List<Publication> findAllpublicationtri();
	@Query(value= "select count (p) from publication p where p.user=:user ",nativeQuery = true)
	int getnbPublicationsByUser(@Param("user") User user);
//	@Query(value="SELECT * FROM `publication` JOIN user u JOIN subscription s WHERE s.subscription.etat=:etat", nativeQuery = true)
//	List<Publication> pubs(@Param("etat") Etat etat);
	
	
}


