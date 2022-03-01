package tn.esprit.spring.repositories;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Comment;



public interface CommentRepository extends CrudRepository<Comment, Integer>  {

	



}
