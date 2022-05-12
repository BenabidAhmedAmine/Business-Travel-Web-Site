package tn.esprit.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Service.IDomainActivityService;

@RestController
@Api(tags = "Management of DomainActivity")
@RequestMapping("DomainActivity")
public class DomainActivityController {
	
	@Autowired
	IDomainActivityService domainActivityService;
	
	@ApiOperation(value = "retrieve synonyms")
	@GetMapping("/retrieve-synonyms/{word}")
	@ResponseBody
	public List<String> getSynonyms(@PathVariable String word){
		String  url ="http://localhost:9393/SpringDic/Dictionary/retrieve-synonyms/";
		 RestTemplate restTemplate = new RestTemplate();
ResponseEntity<List> call= restTemplate.getForEntity(url+word,List.class,word);
	    System.out.println(call.getBody());
		
		return call.getBody() ;
		
		

}
	
	@ApiOperation(value = "hello")
	@GetMapping("/hello")
	@ResponseBody
	public String hello(){
		
		return "hello";
		

}
}
