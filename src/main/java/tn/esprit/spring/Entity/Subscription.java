package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
public class Subscription implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriptionId;
	
	private String title;
	@Enumerated(EnumType.STRING)
	private Etat etat ;
	
	
	@OneToOne
	private User userr;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
 //@OneToOne(mappedBy="subscription")
	//private Employee employee;
}
