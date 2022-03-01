package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "Produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; 
    @NotNull
	@Column(name="code")
	private String code;
    @NotNull
	@Column(name="libelle")
	private String libelle;
	@NotNull
	@Column(name="prixUnitaire")
	private Float prixUnitaire;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Stock Stock;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Rayon Rayon;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseur;
	
	@OneToOne
	private DetailProduit DetailProduit;
	
	@OneToMany(mappedBy="produit",cascade = CascadeType.ALL)
	private Set<DetailFacture> DetailFactures;

	
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
}
