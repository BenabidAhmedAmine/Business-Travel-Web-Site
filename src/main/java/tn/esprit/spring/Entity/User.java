package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
 @Getter
@Setter
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String login;
	private String password;
	private String photo;
	private String firstName;
	private String lastName;
	private String email;
	private DomainActivity domainActivity;
	private Profession profession;
	

	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<Profession> professions;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<FeedBack> feedbacks;
	
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Complaints> complaints;
	
	
	
	

	
	
	
}
