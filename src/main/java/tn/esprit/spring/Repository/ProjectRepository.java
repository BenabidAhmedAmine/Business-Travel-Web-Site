package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	
	
	//
	@Query("SELECT count(*) FROM Project p join p.users u where u.Id =:id")
	public int countProject(@Param ("id") Long Id);
}
