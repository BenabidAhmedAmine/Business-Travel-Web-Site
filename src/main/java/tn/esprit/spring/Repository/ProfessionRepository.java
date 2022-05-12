package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Profession;

@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long>{

}
