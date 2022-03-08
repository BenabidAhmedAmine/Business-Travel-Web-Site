package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/Affect-Badge/{idUser}")
	@ResponseBody
	public Badge AffectBadge(@PathVariable(name="idUser")Long idUser){
		
		return userService.AffectBadge(idUser) ;
		
	}
	@ApiOperation(value = "Search employee By Name ")
	@GetMapping("/Search-employee-By-Name/{firstName}/{lastName}/{companyName}")
	public List<User> SearchEmployeesByName(@PathVariable(name="firstName")String firstName, @PathVariable(name="lastName")String lastName,@PathVariable(name="companyName")String companyName){
		
		return userService.SearchEmployeesByName(firstName, lastName, companyName);
	}
	
	@ApiOperation(value = "Search employee By Profession")
	@GetMapping("/Search-employee-By-Profession/{nameProfession}/{companyName}")
	@ResponseBody
	public List<User> SearchEmployeesByProfession(@PathVariable(name="nameProfession")String nameProfession, @PathVariable(name="companyName")String companyName){
		
		return userService.SearchEmployeesByProfession(nameProfession, companyName);
	}
	
	
	@ApiOperation(value = "get All Emmployees")
	@GetMapping("/get-All-Emmployees-OfCompany/{companyName}")
	@ResponseBody
	public List<User> getAllEmmployeesOfCompany(@PathVariable(name="companyName")String companyName){
		return userService.getAllEmmployeesOfCompany(companyName);
	}
	
	
	
	@ApiOperation(value = "get Company Name")
	@GetMapping("/get-Company-Name/{idUser}")
	@ResponseBody
	public User getCompanyName(@PathVariable(name="idUser")Long idUser){
		return userService.getCompanyName(idUser);
	}
	
	
	@ApiOperation(value = "calcul feedback")
	@GetMapping("/calcul-feedback/{idUser}")
	@ResponseBody
	public int calculFeedback(@PathVariable(name="idUser") Long idUser){
		return userService.calculFeedback(idUser) ;
	}
	
	@ApiOperation(value = "calcul score complaints")
	@GetMapping("/calcul-score-complaints/{idUser}")
	@ResponseBody
	public int nbrTravelsComparedWithComplaints(@PathVariable(name="idUser")Long idUser){
		return userService.nbrTravelsComparedWithComplaints(idUser);
	}
	
	@ApiOperation(value = "calcul score likes")
	@GetMapping("/calcul-score-likes/{idUser}")
	@ResponseBody
	public int nbrPubComparedWithSubscribersAndLikes(@PathVariable(name="idUser")Long idUser){
		return userService.nbrPubComparedWithSubscribersAndLikes(idUser) ;
	}
	
	
	@ApiOperation(value = "calcul Subcription")
	@GetMapping("/calcul-Subcription/{idUser}")
	@ResponseBody
	public int calculSubcription(@PathVariable(name="idUser")Long idUser){
		return userService.calculSubcription(idUser);
	}
	
	@ApiOperation(value = "calcul Projet")
	@GetMapping("/calcul-projet/{idUser}")
	@ResponseBody
	public int calculProjet(@PathVariable(name="idUser")Long idUser){
		return userService.calculProjet(idUser);
	}
	
	@ApiOperation(value = "calcul Sub")
	@GetMapping("/calcul-Sub/{idUser}")
	@ResponseBody
	public Integer getNbrLikesOfPub(@PathVariable(name="idUser") Long idUser){
		return userService.getNbrLikesOfPub(idUser);
	}
	
}
