package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Entity.Profession;
import tn.esprit.spring.Service.IProfessionService;

@RestController
@Api(tags = "Management of Profession")
@RequestMapping("Profession")
public class ProfessionController {
	
		
	@Autowired
	IProfessionService professionService ; 
		

	@ApiOperation(value = "add Profession ")
	@PostMapping("/add-Profession")
	@ResponseBody
	public Profession addProfession(@RequestBody Profession p){
			
	return	professionService.addProfession(p) ;
			
	}


}
