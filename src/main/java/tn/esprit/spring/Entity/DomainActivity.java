package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class DomainActivity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long domainId;
	private String name;
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="domainActivity")
	private Set<User> users;

}
