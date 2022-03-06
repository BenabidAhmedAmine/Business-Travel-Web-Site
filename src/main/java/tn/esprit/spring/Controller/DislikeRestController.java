package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Entity.Dislike;
import tn.esprit.spring.Entity.Likee;
import tn.esprit.spring.Repository.LikeRepository;
import tn.esprit.spring.Service.DislikeServiceImpl;
import tn.esprit.spring.Service.LikeeServiceImpl;

@RestController
@Api(tags = "Dislike management")
@RequestMapping("/dislike")
public class DislikeRestController {

	
	@Autowired
	DislikeServiceImpl dislikeService;
	
	@Autowired 
	DislikeServiceImpl dislikeRepository;
	
	
	@ApiOperation(value = "Ajouter une dislike ")
	@PostMapping("/add-dislike")
	@ResponseBody
	public Dislike addDislike(@RequestBody Dislike dislike)
	{
	Dislike d  = dislikeService.addDislike(dislike);
	return d ;
	}
	
	
	
	
	
	
	@ApiOperation(value = "Supprimer une dislike par Id")
	@DeleteMapping("/remove-dislike/{iddislike}")
	@ResponseBody
	public void removeDislike(@PathVariable("iddislike") Integer iddislike) {
		dislikeService.deleteDislike(iddislike);
	}
	
	

	@PostMapping("/add-Dislike/{pub-Id}")
	public void ajouterEtaffecterListeLikee(@RequestBody Dislike d,@PathVariable ("pub-Id") Integer pubId ){
 	
 		       dislikeService.ajouterEtaffecterdislike(d, pubId);
	}


@PostMapping("/add-Dislike/{pub-Id}/{Id}")
public void ajouterEtaffecterListeLikee(@RequestBody Dislike d,@PathVariable ("pub-Id") Integer pubId,@PathVariable ("Id") Long Id ){
	
		       dislikeService.ajouterEtaffecterlike(d, pubId, Id);
		       }
			
}


