package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.StatusComplaints;
import tn.esprit.spring.Entity.User;




@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints, Long>{
	public List<Complaints> findByStatusComplaints(StatusComplaints statusComplaints);
	public List<Complaints> findByToUser(User user);
	

	//public List<Complaints> findByUserFirstName(String firstname);
	@Query("select count(c) from Complaints c where c.statusComplaints=:statusComplaints")
	int getComplaintsByStatusComplaints(@Param("statusComplaints") StatusComplaints statusComplaints);
	
	@Query("select count(c) from Complaints c where c.toUser.Id=:Id")
	int getnbrComplaintsByUser(@Param ("Id") Long Id);
	
	/*@Query("SELECT count(*) FROM Complaints c where c.user.userId=:userId ")  
	 public long getnbComParUser(@Param ("userId") long userId);*/
	
	@Query("SELECT COUNT(DISTINCT to_user_id) FROM Complaints c ")  
    public int SommeComplaint();
	
	
	//
	@Query("SELECT count(*) FROM Complaints c where (c.toUser.Id =:id)")
	public int countComplaints(@Param ("id") Long id);

	
}
