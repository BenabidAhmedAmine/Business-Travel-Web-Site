package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Voiture;
import tn.esprit.spring.service.IVoitureService;

@RestController
@RequestMapping("Voiture")
public class VoitureController {

	@Autowired
	IVoitureService voitureService;
	
	@PostMapping("/add-voiture")
	@ResponseBody
	public void ajouterVoiture(@RequestBody Voiture voiture){
		voitureService.ajouterVoiture(voiture);
		
	}
	@PostMapping("/ParcAuto-Voiture/{idParcAuto}/{idVoiture}")
	@ResponseBody
	public void affecterParcAutoAVoiture(@PathVariable(name="idParcAuto")Long idParcAuto,@PathVariable(name="idVoiture") Long idVoiture){
		
		voitureService.affecterParcAutoAVoiture(idParcAuto, idVoiture);
	}
}
