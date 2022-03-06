package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Dislike;

@Repository
public interface DislikeRepository extends CrudRepository<Dislike, Integer>{

}
