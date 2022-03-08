package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	private String photo;
	private String firstName;
	private String lastName;
	private String companyName;
	private Boolean active;
	
	
	public User( @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String photo, String firstName, String lastName,
			Boolean active) {
		super();

		this.username = username;
		this.email = email;
		this.password = password;
		this.photo = photo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
	}
	
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<Role> roles, String photo, String firstName,
			String lastName, Boolean active) {
		super();
		Id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.photo = photo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
	}
	
	public Long getUserId() {
		return Id;
	}

	public void setUserId(Long userId) {
		this.Id = userId;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
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
	private Set<Joining> Joinings;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Profession profession;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<FeedBack> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
	@JsonIgnore
	private Set<Complaints> complaints;
	
	@OneToMany( mappedBy="user")
	private Set<Publication> Publications;
	
	@OneToMany(mappedBy = "user")
	private Set<Subscription> subscriptions;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Set<Chat> chats;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Set<Project> projects;
	

}
