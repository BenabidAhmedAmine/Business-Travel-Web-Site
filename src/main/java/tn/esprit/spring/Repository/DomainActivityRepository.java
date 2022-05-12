package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.DomainActivity;

@Repository
public interface DomainActivityRepository extends CrudRepository<DomainActivity, Long> {

}
