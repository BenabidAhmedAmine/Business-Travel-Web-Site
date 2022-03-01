package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.entity.Stock;



public interface StockRepository extends CrudRepository<Stock,Long > {
	@Query("SELECT s FROM Stock s WHERE s.qte<s.qteMin")
	List<Stock> retrieveStatusStock();

}
