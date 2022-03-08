package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Profession;
import tn.esprit.spring.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	//profile company
	@Query("select u from User u join u.roles r where u.companyName=:companyName and r.id=2 ")
	List<User> getAllEmployeesOfCompany(@Param("companyName") String companyName);
	
	//profile company
    @Query("select u from User u join u.roles r where (u.firstName like:firstName or u.lastName like:lastName) and u.companyName=:companyName  and r.id=2 ")
    List<User> findEmployeesOfCompanyByname(@Param("firstName") String firstName, @Param("lastName") String lastName,@Param("companyName")
    String companyName);
	
	
	//profile company
	@Query("select u from User u join u.roles r where u.profession.name=:profession and u.companyName=:companyName and r.id=2 ")
	List<User> findEmployeesOfCompanyByProfessionsName(@Param("profession") String profession, @Param("companyName") String companyName);
	
	//profile employe
	@Query("select u from User u where u.firstName=:companyName or u.lastName=:companyName")
	User getCompanyOfEmployee(@Param("companyName") String companyName);
	
	
	//aziz
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	
	
}
