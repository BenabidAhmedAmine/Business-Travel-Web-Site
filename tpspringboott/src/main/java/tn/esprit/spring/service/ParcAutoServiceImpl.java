package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Chauffeur;
import tn.esprit.spring.entity.ParcAuto;
import tn.esprit.spring.entity.Voiture;
import tn.esprit.spring.repository.ParcAutoRepository;

@Service
public class ParcAutoServiceImpl implements IParcAuto {

	
	@Autowired
	ParcAutoRepository parcAutoRepository;
	
	@Override
	public List<Chauffeur> listChauffeursParParcAuto(Long idParcAuto) {
		
		 ParcAuto parcAuto = parcAutoRepository.findById(idParcAuto).orElse(null);
		 Set<Voiture> voitures =parcAuto.getVoitures();
		  List<Chauffeur> lChauffeur = new ArrayList<Chauffeur>();
		  for (Voiture v : voitures ){
			   lChauffeur.add(v.getChauffeur());
			   
		  }
		 
		return lChauffeur;
	}

}
