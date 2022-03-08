package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Publication;
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>{
	
	
	//
	@Query("SELECT count(*) FROM Publication p where (p.user.Id =:id)")
	public int countPublications(@Param ("id") Long id);

}
