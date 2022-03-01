package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import tn.esprit.spring.entity.DetailFacture;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;
@Slf4j
@Service
public class FactureServiceImpl implements FactureService {
	

	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		log.info("In retrieveAllFactures Methode");
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		log.info("In cancelFacture Methode");
		Facture f=new Facture();
		f=factureRepository.findById(id).orElse(null);
		if(f==null){
			log.warn("Facture introuvable");
			System.out.println("Facture n existe pas");}
		log.warn("cancelFacture");
		f.setActive(false);
		factureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		log.info("In retrieveFacture Methode");
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		Client c= clientRepository.findById(idClient).orElse(null);
		if(c==null)
			log.warn("client n existe pas");
		return (List<Facture>) c.getFactures();
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		Client c= clientRepository.findById(idClient).orElse(null);
		float prixTotal,montantRemise;
		DetailFacture df=new DetailFacture();
		for(DetailFacture d : f.getDetailFactures())
		{
			if(d.getFacture().getIdFacture()==f.getIdFacture())
			{
				df=d;
				break;
			}
				
		}
		prixTotal=df.getQte()*df.getProduit().getPrixUnitaire();
		montantRemise=prixTotal*df.getPourcentageRemise();
		f.setMontantFacture(prixTotal);
		df.setPrixTotal(prixTotal);
		f.setMontantRemise(montantRemise);
		df.setMontantRemise(montantRemise);
		f.setClient(c);
		return factureRepository.save(f);
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		Float ChiffreAffaireParCategorieClient=(float) 0;
		List<Client> Clients=clientRepository.findBycategorieClient(categorieClient);
		List<Facture> Factures=factureRepository.findBydateFactureBetween(startDate, endDate);
		for(Client c : Clients)
		{
			for(Facture f:c.getFactures())
			{
				if(f.getDateFacture().after(startDate)&&f.getDateFacture().before(endDate))
				{
					ChiffreAffaireParCategorieClient+=f.getMontantRemise();
				}
			}
			
		}
		return ChiffreAffaireParCategorieClient;
	}

}
