package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.User;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pubId;
	
	
	private String contents;
	
	private Date datePub = new Date(System.currentTimeMillis());
	
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "publication")
	private Set<Comment> comments;
	
	//@ManyToMany(mappedBy="publications")
	//private Set<User> users;
	
}
