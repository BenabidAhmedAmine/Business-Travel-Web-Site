package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company extends User {
	
	private String firstName;
	private DomainActivity domainActivity;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="company")
	private Set<Invitation> invitations;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="company")
	private Set<DomainActivity> domainActivitys;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="company")
	private Set<Travel> travels;

	@OneToMany(cascade = CascadeType.ALL , mappedBy="company")
	private Set<Business> allBusiness;

}
