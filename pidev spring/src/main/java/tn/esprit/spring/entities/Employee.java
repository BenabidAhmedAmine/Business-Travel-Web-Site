package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String FName;
	private String LName;
	private int note;
	private String Email;
	@ManyToOne
	@JsonIgnore
	private Company company;
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Joining> joinings;
	@OneToOne
	@JsonIgnore
	private Travel travel;
	@ManyToOne
	@JsonIgnore
	private Project project;
	@OneToOne(mappedBy="employee")
	@JsonIgnore
	  private Ticket ticket;
}
