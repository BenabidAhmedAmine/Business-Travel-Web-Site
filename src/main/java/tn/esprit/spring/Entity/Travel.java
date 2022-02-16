package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Travel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelId;
	private Status status;
	@Temporal(TemporalType.DATE)
	private Date dateDeparting;
	@Temporal(TemporalType.DATE)
	private Date dateReturning;
	private String destination;
	private String perimeter;

	
	@ManyToOne
	private Company company;
}
