package tn.esprit.spring.Entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin extends User {
	
	private String firstName;
	private String lastName;

}
