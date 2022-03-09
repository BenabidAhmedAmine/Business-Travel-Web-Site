package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
