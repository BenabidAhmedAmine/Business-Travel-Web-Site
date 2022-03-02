package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.BadWord;

@Repository
public interface BadWordRepository extends CrudRepository<BadWord ,Long> {

}
