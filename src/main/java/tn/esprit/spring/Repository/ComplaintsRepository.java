package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Complaints;
import tn.esprit.spring.Entity.FeedBack;
import tn.esprit.spring.Entity.Matching;
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
	
	/*
	@Query("select f  from FeedBack f  where ( f.user.matching1.user1.Id=:Id and f.ToUser.matching2.user2.Id=:Id1"
			+ "and f.user.matching1.matchuser1=:yes and f.ToUser.matching2.matchuser2=:yes1)")
	public Complaints MATCHexist(@Param("Id") Long Id,@Param("Id1") Long Id1,@Param("matchuser1") Set<Matching> yes,@Param("matchuser2") Set<Matching> yes1);
*/
	

}
