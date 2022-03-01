package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Table( name = "Client")
public class Client implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")
private Long idClient; 
@NotNull
@Column(name="nom")
private String nom;
@NotNull
@Column(name="prenom")
private String prenom;
@NotNull
@Column(name="email")
private String email;
@NotNull
@Column(name="password")
private String password;
@NotNull
@Temporal(TemporalType.DATE)
@Column(name="dateNaissance")
private Date dateNaissance;
@NotNull
@Enumerated(EnumType.STRING)
@Column(name="profession")
private Profession profession;
@NotNull
@Enumerated(EnumType.STRING)
@Column(name="categorieClient")
private CategorieClient categorieClient;

@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
private Set<Facture> Factures ;

public Long getIdClient() {
	return idClient;
}

public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
public Date getDateNaissance() {
	return dateNaissance;
}

public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}

}