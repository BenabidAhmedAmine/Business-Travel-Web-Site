package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
@Repository
public interface JoiningRepository extends CrudRepository<Joining, Long>{

	List<Joining> findByProject(Project project);
}
