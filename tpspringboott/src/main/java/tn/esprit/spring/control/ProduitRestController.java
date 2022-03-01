package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@Api(tags = "Produit management")
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	// http://localhost:8087/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits =produitService.retrieveAllProduits() ;
		return listProduits;}
	
	// http://localhost:8087/SpringMVC/produit/retrieve-produit/1
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
	return produitService.retrieveProduit(produitId) ;
	}
	// http://localhost:8087/SpringMVC/produit/add-produit1
	@PostMapping("/add-produit1")
	@ResponseBody
	public void addProduit1(@RequestBody Produit p)
	{
	produitService.addProduit1(p,p.getRayon().getIdRayon(),p.getStock().getIdStock());
	}
	// http://localhost:8087/SpringMVC/produit/add-produit
	@PostMapping("/add-produit/{id-rayon}/{id-stock}")
	@ResponseBody
	public void addProduit(@RequestBody Produit p,@PathVariable("id-rayon") Long idRayon,@PathVariable("id-stock") Long idStock)
	{
	produitService.addProduit(p, idRayon, idStock);
	}
	// http://localhost:8087/SpringMVC/produit/assign-Fournisseur-ToProduit
	@PutMapping("/assign-Fournisseur-ToProduit/{fournisseur-Id}/{id-produit}")
	@ResponseBody
	public void assignFourToProduit(@PathVariable("fournisseur-Id") Long idFourn,@PathVariable("id-produit") Long idProduit)
	{
	produitService.assignFournisseurToProduit(idFourn, idProduit);
	}
	// http://localhost:8087/SpringMVC/produit/assign-produit-Tostock
	@PutMapping("/assign-produit-Tostock/{stock-Id}/{id-produit}")
	@ResponseBody
	public void assignProdToStock(@PathVariable("stock-Id") Long idStock,@PathVariable("id-produit") Long idProduit)
	{
	produitService.assignProduitToStock(idProduit, idStock);
	}
	// http://localhost:8087/SpringMVC/produit/getRevenuBrutProduit
	@GetMapping("/getRevenuBrutProduit/{produit-id}/{d1}/{d2}")
	@ResponseBody
	public float getRevenuBrutProduit(@PathVariable("produit-id") Long produitId,@PathVariable("d1") Date d1,@PathVariable("d2") Date d2) {
	return produitService.getRevenuBrutProduit(produitId, d1, d2) ;
	}
	// http://localhost:8087/SpringMVC/produit/retrieveStatusStock
		//@GetMapping("/retrieveStatusStock")
		//@ResponseBody
		//public String retrieveStatusStock() {
		//return produitService.retrieveStatusStock() ;
		//}
}
