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
	
	//List<Publication> findByUserSubscriptionsUserr(User u);
	List<Publication> findByUser(User u);
	@Query(value= "select * from publication  order by date_Pub desc",nativeQuery = true)
	List<Publication> findAllpublicationtri();
	@Query(value= "select count (p) from publication p where p.user=:user ",nativeQuery = true)
	int getnbPublicationsByUser(@Param("user") User user);
@Query(value="SELECT DISTINCT * FROM publication p LEFT JOIN subscription s ON s.user_id=p.user_id;", nativeQuery = true)
List<Publication> pubs(@Param("user_id") Long user_id);
	
	//@Query("select *  from publication p "
		//	+ "join p.user u "
		//	+ "join u.subscription s "
		//	+ "where s.etat=:subscribe")
//public List<Publication> getAllpublicationBysubscription(@Param("etat")Etat etat);
//}
	
	
}