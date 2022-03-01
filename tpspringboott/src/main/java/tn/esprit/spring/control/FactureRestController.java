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
import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.FactureService;

@RestController
@RequestMapping("/facture")
@Api(tags = "Facture management")
public class FactureRestController {
	@Autowired
	FactureService factureService;
	// http://localhost:8087/SpringMVC/facture/retrieve-all-facture
	@GetMapping("/retrieve-all-facture")
	@ResponseBody
	public List<Facture> getFactures() {
		List<Facture> listFactures = factureService.retrieveAllFactures();
		return listFactures;}
	
	// http://localhost:8087/SpringMVC/facture/retrieve-facture/1
		@GetMapping("/retrieve-facture/{facture-id}")
		@ResponseBody
		public Facture retrieveFacture(@PathVariable("facture-id") Long idFacture) {
		return factureService.retrieveFacture(idFacture);
		}
		
		// http://localhost:8087/SpringMVC/facture/cancel-facture/1
		@PutMapping("/cancel-facture/{facture-id}")
		@ResponseBody
		public void cancelFacture(@PathVariable("facture-id") Long idFacture) {
			factureService.cancelFacture(idFacture);
		}
		// http://localhost:8087/SpringMVC/facture/retrieve-facture-by-client/1
		@GetMapping("/retrieve-facture-by-client/{client-id}")
		@ResponseBody
		public List<Facture> retrieveFactureByClient(@PathVariable("client-id") Long idClient) {
		return factureService.getFacturesByClient(idClient);
		}
		
		// http://localhost:8087/SpringMVC/facture/add-facture/1
				@PostMapping("/add-facture/{client-id}")
				@ResponseBody
				public Facture addFacture(@RequestBody Facture f,@PathVariable("client-id") Long idClient) {
					return factureService.addFacture(f, idClient);
				}
				
				// http://localhost:8087/SpringMVC/facture/get-chiffre-affairepar-catclient/
				@GetMapping("/get-chiffre-affairepar-catclient/{categorie-client}/{date1}/{date2}")
				@ResponseBody
				public float getChiffreAffaireParCatClient(@PathVariable("categorie-client")  CategorieClient categorieClient,@PathVariable("date1") Date d1,@PathVariable("date2") Date d2) {
				return factureService.getChiffreAffaireParCategorieClient(categorieClient, d1, d2);
				}

}
