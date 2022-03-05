package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Chat  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatId;
	private String username; 
	private String message;
	@Temporal(TemporalType.DATE)
	Date sendingdate;
	
	
	@OneToOne
	private User userr;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//User users;
	
	//@OneToOne
	//private User user;
	//@ManyToMany(mappedBy="chats")
	//private Set<Employee> employees;

}
