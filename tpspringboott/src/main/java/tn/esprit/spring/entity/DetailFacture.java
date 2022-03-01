package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table( name = "DetailFacture")

public class DetailFacture implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture; 
	
	@Column(name="qte")
	private Integer qte;
	
	@Column(name="prixTotal")
	private Float prixTotal;
	
	@Column(name="pourcentageRemise")
	private Integer pourcentageRemise;
	
	@Column(name="montantRemise")
	private Float montantRemise;
	
	@ManyToOne
	Produit produit;
	
	@ManyToOne
	Facture facture;
	public Long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}
	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

}
