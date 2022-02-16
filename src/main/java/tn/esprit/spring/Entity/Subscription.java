package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subscription implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriptionId;
	private String employeeId; 
	private String title;
	
 @OneToOne(mappedBy="subscription")
	private Employee employee;
}
