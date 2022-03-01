package tn.esprit.spring.service;

import tn.esprit.spring.entity.Voiture;

public interface IVoitureService {
	
	void ajouterVoiture(Voiture voiture);
	void affecterParcAutoAVoiture(Long idParcAuto, Long idVoiture);

	
}
