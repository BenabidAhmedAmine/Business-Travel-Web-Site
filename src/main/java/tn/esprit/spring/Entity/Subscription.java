package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Subscription implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subscriptionId; 
	private String title;
	
 @ManyToMany(mappedBy="subscriptions",cascade = CascadeType.ALL)
 @JsonIgnore
 private Set<User> users;
}
