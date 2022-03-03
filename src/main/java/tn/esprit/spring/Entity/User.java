package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Invitation> invitations;
	
	@ManyToOne
	@JsonIgnore
	private DomainActivity domainActivity;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Travel> travels;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Business> allBusiness;
	
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Profession> professions;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<FeedBack> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Complaints> complaints;
	
	@OneToMany( mappedBy="user")
	private Set<Publication> Publications;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JsonIgnore
	private Set<Subscription> subscriptions;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JsonIgnore
	private Set<Chat> chats;
	

}
