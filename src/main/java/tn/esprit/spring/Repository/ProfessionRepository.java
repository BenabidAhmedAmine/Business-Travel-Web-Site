package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.DomainActivity;
import tn.esprit.spring.Entity.Profession;

@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long>{

	List<Profession> findByNameIn(List<String> lSynonyms);
}
