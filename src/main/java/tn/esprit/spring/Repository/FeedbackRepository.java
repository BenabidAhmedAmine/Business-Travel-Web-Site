package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.FeedBack;


@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{
	
	@Query(nativeQuery = true, value ="select `id_feed_back`, `date_feedback`, `note`, `review`, `to_user_id`, `user_id` from `feed_back` where `id_feed_back` order by date_feedback desc limit 3")
	public List<FeedBack> listLastReviews();
	
	@Query("select f  from FeedBack f  where ( f.user.Id=:Id and f.ToUser.Id=:Id1)")
	public FeedBack FeedBackexist(@Param("Id") Long Id,@Param("Id1") Long Id1);
	
	@Query("SELECT count(*) FROM FeedBack f where (f.ToUser.Id =:Id)")
	public int nbreviews(@Param ("Id") Long Id);
	
	@Query("SELECT SUM(f.note) FROM FeedBack f where (f.ToUser.Id =:Id)")  
    public float SommeNote(@Param ("Id") Long Id);
	

	@Query(value="Select (AVG(f.note)) as moyenne from feed_back f "
			+ "GROUP BY(f.to_user_id) ORDER BY moyenne desc limit 1" ,nativeQuery=true)
	  public Long top_MOYENNE_user();
	
	@Query("SELECT (AVG(f.note)) FROM FeedBack f where (f.ToUser.Id =:Id)")
	  public Long Moyenne_user(@Param ("Id") Long Id);
	  
	

	//
	@Query("select f from FeedBack f  where  f.ToUser.Id=:userId")
	public List<FeedBack> FeedBackUserExist(@Param("userId") Long userId);

	@Query("SELECT SUM(f.note) FROM FeedBack f where (f.ToUser.Id =:Id)")  
    public Integer SommeNote1(@Param ("Id") Long Id);
	

	
}
