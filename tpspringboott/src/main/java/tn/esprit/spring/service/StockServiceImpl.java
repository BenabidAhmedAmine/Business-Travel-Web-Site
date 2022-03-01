package tn.esprit.spring.service;

import java.util.List;
import lombok.AccessLevel;
import lombok.extern.log4j.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
@Slf4j
@Service
public class StockServiceImpl implements StockService  {
	
	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> retrieveAllStocks(){
	return 	(List<Stock>) stockRepository.findAll();
	}
	public Stock addStock(Stock s){
		return stockRepository.save(s);
	}
	public Stock updateStock(Stock u){
		return stockRepository.save(u);
	}
	public Stock retrieveStock(Long id){
		Stock s= stockRepository.findById(id).orElse(null);
		if(s==null)
			log.info("Stock introuvable");
		return stockRepository.findById(id).orElse(null);
	}
	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
	}
	@Scheduled(cron="0 0 22 * * ?")
	@Override
	public void retriveStatusStock() {
		List<Stock> stocks=stockRepository.retrieveStatusStock();
		for(Stock s : stocks){
			for(Produit p :s.getProduit())
			{
				log.info(p.toString());
			}
		}
		
	}


}
