package tn.esprit.spring;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest {
	@Autowired
	StockService stockService;
	@Test
	/*
	public void testAddStock() {
	List<Stock> stocks = stockService.retrieveAllStocks();
	int expected=stocks.size();
	Stock s = new Stock();
	s.setLibelleStock("stock test");
	s.setQte(10);
	s.setQteMin(100);
	Stock savedStock= stockService.addStock(s);
	assertEquals(expected+1, stockService.retrieveAllStocks().size());
	assertNotNull(savedStock.getLibelleStock());
	stockService.deleteStock(savedStock.getIdStock());
	}*/
	public void testAddStock() {
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		
		assertNotNull(savedStock.getIdStock());
		assertNotNull(savedStock.getQte());
		assertTrue(savedStock.getLibelleStock().length()>0);
		stockService.deleteStock(savedStock.getIdStock());
	}
	@Test
	public void testdeleteStock()
	{
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertEquals(expected, stockService.retrieveAllStocks().size());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
}
