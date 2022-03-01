package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.FeedBack;


@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{

}
