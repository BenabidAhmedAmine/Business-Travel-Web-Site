package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Chat;



public interface ChatRepository extends CrudRepository<Chat, Integer>  {
 //public List<Chat> findalluser();
}
