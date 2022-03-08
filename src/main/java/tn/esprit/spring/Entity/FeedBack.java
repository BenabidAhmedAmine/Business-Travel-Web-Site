package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFeedBack ;

	@Temporal (TemporalType.DATE)
	private Date DateFeedback;
	private int note;
	private String review ;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@OneToOne
	private User ToUser;
	
}
