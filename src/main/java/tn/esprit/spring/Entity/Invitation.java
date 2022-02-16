package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invitation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invitationId;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	private Company company;
}
