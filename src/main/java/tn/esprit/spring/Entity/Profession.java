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
public class Profession implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long professionId;
	private String name;
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy="profession")
	private Set<User> users;
	

}
