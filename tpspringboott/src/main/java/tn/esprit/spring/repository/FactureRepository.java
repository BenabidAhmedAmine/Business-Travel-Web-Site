package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Facture;

public interface FactureRepository extends CrudRepository<Facture,Long> {
	List<Facture> findBydateFactureBetween(Date d1,Date d2);

}
