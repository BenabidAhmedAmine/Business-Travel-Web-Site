package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Chat;



public interface ChatRepository extends CrudRepository<Chat, Integer>  {

}
