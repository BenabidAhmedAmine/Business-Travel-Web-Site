package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publication implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pubId;
	private String username; 
	private String title;
	private String contents;
	@Temporal(TemporalType.DATE)
	Date datePub;
	
	private int like ; 
	private int dislike ;
	@OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
	private Set<Comment> comments;
    
	@ManyToOne
	private User user;
}
