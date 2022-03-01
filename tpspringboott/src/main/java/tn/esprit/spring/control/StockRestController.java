package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;

@RestController
@Api(tags = "Stock management")
@RequestMapping("/stock")
public class StockRestController {
	@Autowired
	StockService stockService;
	// http://localhost:8087/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;}
	
	// http://localhost:8087/SpringMVC/stock/retrieve-stock/1
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
	return stockService.retrieveStock(stockId);
	}
	
	// http://localhost:8087/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock c)
	{
	Stock stock = stockService.addStock(c);
	return stock;
	}
	
	// http://localhost:8087/SpringMVC/stock/remove-stock/1
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}
	
	// http://localhost:8087/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}

}
