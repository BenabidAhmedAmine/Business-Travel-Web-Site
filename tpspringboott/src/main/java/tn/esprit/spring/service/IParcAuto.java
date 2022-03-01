package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Chauffeur;

public interface IParcAuto {
	
	List<Chauffeur> listChauffeursParParcAuto(Long idParcAuto);

}
