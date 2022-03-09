package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Company;
import tn.esprit.spring.entities.Employee;
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	@Query(value="SELECT lname FROM `company` JOIN employee e WHERE e.company_id=1 ORDER BY e.note ",nativeQuery=true)
	List<Employee> emplbynote(@Param("company_id") Long company_id);
	
}
