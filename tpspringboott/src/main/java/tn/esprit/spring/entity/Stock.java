package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table( name = "Stock")

public class Stock implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock; 
	@NotNull 
	@Column(name="qte")
	private Integer qte;
    @NotNull
	@Column(name="qteMin")
	private Integer qteMin;
    @NotNull
	@Column(name="LibelleStock")
	private String LibelleStock;
	
	@OneToMany(mappedBy="Stock",cascade = CascadeType.ALL)
	private Set<Produit> Produit;

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Integer getQteMin() {
		return qteMin;
	}

	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}

	public String getLibelleStock() {
		return LibelleStock;
	}

	public void setLibelleStock(String libelleStock) {
		LibelleStock = libelleStock;
	}
}
