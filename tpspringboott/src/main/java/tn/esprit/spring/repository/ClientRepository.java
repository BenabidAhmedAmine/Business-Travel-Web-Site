package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;

public interface ClientRepository extends CrudRepository<Client,Long >  {
	//Sql
	@Query(value = "SELECT * FROM Client c WHERE c.profession= :profession" ,
			nativeQuery = true)
			List<Client> retrieveClientsByProfessionSql(@Param("profession") Profession
			profession);
	
	
	@Query(value = "SELECT * FROM Client c WHERE c.dateNaissance >= date1 AND c.dateNaissance <= date2" ,
			nativeQuery = true)
			List<Client> retrieveClientsBydateNaissanceSql(@Param("date1") Date
			date1,@Param("date2") Date date2);
	//JPQL
	
	@Query("SELECT c FROM Client c WHERE c.profession= :profession")
	List<Client> retrieveClientsByProfessionJpql(@Param("profession") Profession
	profession);
	
	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance >= date1 AND c.dateNaissance <= date2" )
			List<Client> retrieveClientsBydateNaissanceJpql(@Param("date1") Date
			date1,@Param("date2") Date date2);
	List<Client> findBycategorieClient(CategorieClient categorieClient);

}
