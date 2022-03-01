package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ParcAuto;
import tn.esprit.spring.entity.Voiture;
import tn.esprit.spring.repository.ParcAutoRepository;
import tn.esprit.spring.repository.VoitureRepository;

@Service
public class VoitureServiceImpl implements IVoitureService {
	
	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ParcAutoRepository parcAutoRepository;

	@Override
	public void ajouterVoiture(Voiture voiture) {
		
		voitureRepository.save(voiture);
	}

	@Override
	public void affecterParcAutoAVoiture(Long idParcAuto, Long idVoiture) {
		Voiture voiture= voitureRepository.findById(idVoiture).orElse(null);
		ParcAuto parcAuto= parcAutoRepository.findById(idParcAuto).orElse(null);
		parcAuto.getVoitures().add(voiture);
		parcAutoRepository.save(parcAuto);
	}

	
	
}
