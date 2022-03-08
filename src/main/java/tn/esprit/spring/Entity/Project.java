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
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int nbreEmpDemande;
	private String duree;
	private String description;
	
	private String domaineActivite;
	
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private Set<Joining> joinings;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy="projects")
	 @JsonIgnore
	private Set<User> users;

}
