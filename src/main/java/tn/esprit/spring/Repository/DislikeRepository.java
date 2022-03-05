package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Dislike;
import tn.esprit.spring.Entity.Publication;

public interface DislikeRepository extends CrudRepository<Dislike, Integer>{

}
