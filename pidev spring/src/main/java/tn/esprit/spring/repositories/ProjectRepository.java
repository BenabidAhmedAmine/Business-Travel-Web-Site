package tn.esprit.spring.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
List<Project> findByNom(String nom);
List<Project> findByDomaineActivite(String domaineActivite);
List<Project> findByNbreEmpDemande(int nbreEmpDemande);
List<Project> findByNomAndDomaineActivite(String nom, String domaineActivite);
List<Project> findByNomAndNbreEmpDemande(String nom, int nbreEmpDemande);
List<Project> findByNomOrDomaineActiviteOrNbreEmpDemande(String nom, String domaineActivite,int nbreEmpDemande);



}
