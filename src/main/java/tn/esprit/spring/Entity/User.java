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
	private Set<Invitation> invitations;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<DomainActivity> domainActivitys;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<Travel> travels;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<Business> allBusiness;
	
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<Profession> professions;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<FeedBack> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	private Set<Complaints> complaints;
	
	@OneToMany(mappedBy = "user")
	private Set<Publication> publications;
	//@ManyToMany
	//@JsonIgnore
	//private Set<Publication> publications;
	
	@OneToOne
	private Subscription subscription;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//private Set<Chat> Chats;
}