package tn.esprit.spring.Controller;

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
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.BadWordFilter;
import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Entity.Publication;
import tn.esprit.spring.Repository.LikeRepository;
import tn.esprit.spring.Service.LikeeServiceImpl;


@RestController
@Api(tags = "Like management")
@RequestMapping("/like")
public class LikeRestController {
	
	@Autowired
	LikeeServiceImpl likeeService;
	@Autowired
	LikeRepository likeRepository;
	
	
	
	
	@ApiOperation(value = "Ajouter une like ")
	@PostMapping("/add-like")
	@ResponseBody
	public Likee addLikee(@RequestBody Likee likee)
	{
	Likee l = likeeService.addLikee(likee);
	return l;
	}
	
	
	
	
	
	
	@ApiOperation(value = "Supprimer une like par Id")
	@DeleteMapping("/remove-like/{idlike}")
	@ResponseBody
	public void removeLike(@PathVariable("idlike") Integer idlike) {
		likeeService.deleteLikee(idlike);
	}
	
	

	@PostMapping("/add-Like/{pub-Id}")
	public void ajouterEtaffecterListeLikee(@RequestBody Likee likee,@PathVariable ("pub-Id") Integer pubId ){
 	
 		       likeeService.ajouterEtaffecterlike(likee, pubId);}
 			


@PostMapping("/add-Like/{pub-Id}/{Id}")
public void ajouterEtaffecterListeLikee(@RequestBody Likee likee,@PathVariable ("pub-Id") Integer pubId,@PathVariable ("Id") Long Id ){
	
		       likeeService.ajouterEtaffecterlike(likee, pubId,Id);
		       }
			

//@GetMapping("/test")
//@ResponseBody
//public String adddislike1()
//{
	
	//	return likeeService.getNbrLikee4();


//}

}

