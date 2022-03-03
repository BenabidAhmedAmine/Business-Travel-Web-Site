package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Entity.Badge;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Service.IUserService;

@RestController
@Api(tags = "Management of User")
@RequestMapping("User")
public class UserController {
	
	@Autowired
	IUserService userService;
	

	@ApiOperation(value = "Affect Badge ")
	@PostMapping("/Affect-Badge")
	@ResponseBody
	public Badge AffectBadge(@RequestBody User user){
		
		return userService.AffectBadge(user) ;
		
	}
	@ApiOperation(value = "Search employee By Name ")
	@GetMapping("/Search-employee-By-Name/{firstName}/{lastName}")
	@ResponseBody
	public List<String> SearchByName(@PathVariable(name="firstName")String firstName, @PathVariable(name="lastName")String lastName){
		
		return userService.SearchByName(firstName, lastName);
	}
	
	@ApiOperation(value = "Search employee By Domain Activity ")
	@GetMapping("/Search-employee-By-Domain-Activity/{nameDomain}")
	@ResponseBody
	public List<String> SearchByDomain(@PathVariable(name="nameDomain")String nameDomain){
		
		return userService.SearchByDomain(nameDomain);
	}
}
