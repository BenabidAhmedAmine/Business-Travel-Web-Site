package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Chauffeur;
import tn.esprit.spring.entity.Voiture;
import tn.esprit.spring.service.IParcAuto;

@RestController
@RequestMapping("ParcAuto")
public class ParcAutoController {

	@Autowired
	IParcAuto parcAutoService;
	
	@PostMapping("/chauffeur-parcauto/{idParcAuto}")
	@ResponseBody
	public List<Chauffeur> listChauffeursParParcAuto(@PathVariable(name="idParcAuto")Long idParcAuto){

		return parcAutoService.listChauffeursParParcAuto(idParcAuto);
	}
}
