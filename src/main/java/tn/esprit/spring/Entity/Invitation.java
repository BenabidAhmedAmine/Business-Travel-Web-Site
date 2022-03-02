package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Invitation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invitationId;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	private User user;

	public Invitation() {
		super();
	}

	public Invitation(int invitationId, Status status, User user) {
		super();
		this.invitationId = invitationId;
		this.status = status;
		this.user = user;
	}

	public int getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(int invitationId) {
		this.invitationId = invitationId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Invitation [invitationId=" + invitationId + ", status=" + status + ", user=" + user + "]";
	}
	
}
