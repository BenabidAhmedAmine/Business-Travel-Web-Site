package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class Complaints implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	private long idComplaint;
	private String object;
	private String message;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Enumerated(EnumType.STRING)
	private StatusComplaints statusComplaints ;


	@ManyToOne
	@JsonIgnore
	private User user;
	
	@OneToOne
	private User toUser;

	
	
}
