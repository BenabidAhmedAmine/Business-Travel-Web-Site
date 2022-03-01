package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idd;
	private String username; 
	private String contents;
	
	//@ManyToMany
	//@JsonIgnore
	//private Set<Chat> chats;
	//@OneToOne
	//Subscription subscription;

   //@OneToMany(mappedBy = "employee")
     //private Set<Publication> publications;

}
