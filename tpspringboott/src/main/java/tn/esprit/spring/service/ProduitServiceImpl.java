package tn.esprit.spring.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;
@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private DetailProduitRepository detailProduitRepository;
	@Autowired
	private RayonRepository rayonRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private FournisseurRepository fornRepository;
	@Autowired
	private FactureRepository factureRepository;
	
	public 	List<Produit> retrieveAllProduits()
	{
		log.info("In retrieveAllProduits Methode");
		return (List<Produit>) produitRepository.findAll();
	}
	public Produit addProduit(Produit p, Long idRayon, Long idStock)
	{
		Rayon r=rayonRepository.findById(idRayon).orElse(null);
		Stock s=stockRepository.findById(idStock).orElse(null);
		log.info("In addProduit Methode");
		p.setRayon(r);
		p.setStock(s);
		//DetailProduit pd=detailProduitRepository.save(p.getDetailProduit());
		return produitRepository.save(p);
	}
	public Produit retrieveProduit(Long id)
	{
		log.info("In retrieveProduit Methode");
		return produitRepository.findById(id).orElse(null); 
	}
	@Override
	public void addProduit1(Produit p, Long idRayon, Long idStock) {
		produitRepository.insertClient(p.getIdProduit(),p.getCode(),p.getLibelle(),p.getPrixUnitaire(),p.getDetailProduit().getIdDetailProduit(), idRayon, idStock);	
	}
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Stock s=stockRepository.findById(idStock).orElse(null);
		Produit p=produitRepository.findById(idProduit).orElse(null);
		if(s==null || p==null)
			log.warn("produit || stock n existe pas");
		else
		{
		p.setStock(s);
		}
		
	}
	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit p=produitRepository.findById(produitId).orElse(null);
		Fournisseur f=fornRepository.findById(fournisseurId).orElse(null);
		if(p==null)
			log.warn("produit || fournisseur n existe pas");
		else{
			p.getFournisseur().add(f);
			produitRepository.save(p);
		}
	}
	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		Float RevenuBrutProduit=(float) 0;
		Produit p=produitRepository.findById(idProduit).orElse(null);
		List<Facture> Factures=factureRepository.findBydateFactureBetween(startDate, endDate);
		for(Facture f:Factures)
		{
			for(DetailFacture df:f.getDetailFactures())
			{
		for(DetailFacture d:p.getDetailFactures())
		{
			if(d.getIdDetailFacture()==df.getIdDetailFacture())
			{
				RevenuBrutProduit+=(d.getQte()*p.getPrixUnitaire());
			}
		}
			}
		}
		return RevenuBrutProduit;
	}
	@Scheduled(cron="0 0 22 * * ?")
	@Override
	public void retrieveStatusStock() {
		List<Produit> Produits=	(List<Produit>) produitRepository.findAll();
		for(Produit p:Produits)
		{
			if(p.getStock().getQte()<p.getStock().getQteMin())
			{
              log.info(p.toString());
			}
			
		}
		
	}
	
}
