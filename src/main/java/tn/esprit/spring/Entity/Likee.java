package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Likee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idlike")
 private int idlike;

	 private int nbrlike = 0;
	 
	 
	 
	 @OneToOne(cascade = CascadeType.ALL)
		private User user;
		@OneToOne(cascade = CascadeType.ALL)
		private Publication publication;
	// @ManyToOne
	//	@JsonIgnore
	//	private Publication publication;
	 
	// @ManyToOne
	//	@JsonIgnore
		//private User user;

}
