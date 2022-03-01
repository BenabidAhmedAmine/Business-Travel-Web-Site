package tn.esprit.spring.repositories;



import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Publication;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {
	//public List<Publication> findByContents(String contents);
	//public Page<Publication> findByContents(String contents,Pageable pageable);
	
	
	
	
	@Query(value= "select * from publication  order by date_Pub desc",nativeQuery = true)
	List<Publication> findAllpublicationtri();
	@Query(value= "select count (*) from publication  ",nativeQuery = true)
	List<Publication> findnumberpub();
	
	
	
}


