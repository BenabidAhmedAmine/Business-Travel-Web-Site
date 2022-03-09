package tn.esprit.spring.repositories;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Company;
import tn.esprit.spring.entities.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Query("SELECT ROUND(AVG(note), 2) FROM Employee WHERE company_id=:company_id")
	public float average(@Param("company_id") Long company_id);
@Query(value= "SELECT destination FROM travel t INNER JOIN employee e WHERE t.travel_id=e.travel_travel_id",nativeQuery = true)
public String pr(@Param("project_id") Long project_id);
@Query(value="SELECT lname FROM `employee` JOIN company c WHERE c.id=:id ORDER BY note LIMIT 5 ",nativeQuery=true)
List<Employee> emplbynote(@Param("id") Long id);
	List<Employee> findTop2ByOrderByNoteDesc();
	@Query(value="SELECT * FROM employee e JOIN company WHERE e.company_id=company_id",nativeQuery=true)
	List<Employee> emplbycomid(@Param("company_id") Long company_id);
@Query(value="SELECT company_id , ROUND(AVG(note)) FROM employee GROUP by company_id",nativeQuery=true)
List<Object[]> companyandheravg();
}
