package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table( name = "DetailProduit")
public class DetailProduit implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit; 

	@Temporal(TemporalType.DATE)
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateDernièreModification")
	private Date dateDernièreModification;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CategorieProduit")
	private CategorieProduit CategorieProduit;

	
	@OneToOne(mappedBy="DetailProduit")
	private Produit Produit;
	
	
	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDernièreModification() {
		return dateDernièreModification;
	}

	public void setDateDernièreModification(Date dateDernièreModification) {
		this.dateDernièreModification = dateDernièreModification;
	}

	public CategorieProduit getCategorieProduit() {
		return CategorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		CategorieProduit = categorieProduit;
	}
   
	public DetailProduit(Date dateCreation,Date dateDernièreModification,CategorieProduit CategorieProduit )
	{
		this.dateCreation=dateCreation;
		this.dateDernièreModification=dateDernièreModification;
		this.CategorieProduit = CategorieProduit;
	}

}
