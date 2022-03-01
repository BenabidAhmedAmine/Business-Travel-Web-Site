package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Entity.DomainActivity;
import tn.esprit.spring.Service.IDomainActivityService;

@RestController
@Api(tags = "Management of DomainActivity")
@RequestMapping("DomainActivity")
public class DomainActivityController {
	
	@Autowired
	IDomainActivityService domainActivityService;
	

	@ApiOperation(value = "add Domain Activity ")
	@PostMapping("/add-Domain-Activity")
	@ResponseBody
	public DomainActivity addDomainActivity(@RequestBody DomainActivity d){
		
		return	domainActivityService.addDomainActivity(d) ;
		
	}

}
