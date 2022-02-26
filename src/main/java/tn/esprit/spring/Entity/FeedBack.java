package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	private long IdFeedback;
	private String Object;
	private String Opinion;
	private String Rainting;
	
	@ManyToOne
	private User user;
	
}
