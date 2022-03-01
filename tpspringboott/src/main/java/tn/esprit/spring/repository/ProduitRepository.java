package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Produit;;

public interface ProduitRepository extends CrudRepository<Produit,Long > {
	//Sql
	@Query(value = "INSERT INTO Produit (idProduit,code,libelle,prixUnitaire,detail_produit_id_detail_produit,rayon_id_rayon,stock_id_stock) VALUES (:idProduit,:code, :libelle, :prixUnitaire, :detail_produit_id, :rayon_id, :stock_id)",
			nativeQuery = true)
			void insertClient(@Param("idProduit") long idProduit, @Param("code") String code,@Param("libelle") String libelle,
			@Param("prixUnitaire") float prixUnitaire, @Param("detail_produit_id") long detail_produit_id,
			@Param("rayon_id") long rayon_id, @Param("stock_id") long stock_id);

}
