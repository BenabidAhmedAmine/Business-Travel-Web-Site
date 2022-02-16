package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends User {
	
	private String firstName;
	private String lastName;
	private String email;
	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="employee")
	private Set<Profession> professions;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="employee")
	private Set<FeedBack> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="employee")
	private Set<Complaints> complaints;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="employee")
	private Set<Publication> Publications;
	
	 @OneToOne
	private Subscription subscription;
	 
	 @ManyToMany(mappedBy="employee", cascade = CascadeType.ALL)
	private Set<Chat> chats;

}
