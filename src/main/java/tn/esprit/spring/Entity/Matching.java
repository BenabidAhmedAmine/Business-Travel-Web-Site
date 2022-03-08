package tn.esprit.spring.Entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Matching implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchingId;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee1_id")
	private User user1;
	
	private String matchuser1;
	
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee2_id")
	private User user2;
	
	private String matchuser2;
	

}
