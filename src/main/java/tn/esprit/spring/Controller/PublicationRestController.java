package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

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
import tn.esprit.spring.Service.PublicationServiceImpl;

import tn.esprit.spring.entities.Publication;



@RestController
@Api(tags = "Publication management")
@RequestMapping("/publication")
public class PublicationRestController {

	@Autowired
	PublicationServiceImpl publicationService;
	
	@ApiOperation(value = "Récupérer la liste des publications")
	@GetMapping("/retrieve-all-publications")
	@ResponseBody
	public List<Publication> getPublications() {
	List<Publication> listPublications = publicationService.retrieveAllPublications();
	return listPublications;
	}
	
	
	
	
	
	@ApiOperation(value = "Ajouter une publications ")
	@PostMapping("/add-publication")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication publication)
	{
	Publication p = publicationService.addPublication(publication);
	return p;
	}
	
	
	@ApiOperation(value = "Mettre a jour une publication")
	@PutMapping("/modify-publication")
	@ResponseBody
	public Publication modifyPublication(@RequestBody Publication publication) {
	return publicationService.updatePublication(publication);
	}
	
	
	
	@ApiOperation(value = "Supprimer une publications par Id")
	@DeleteMapping("/remove-publication/{pubId}")
	@ResponseBody
	public void removePublication(@PathVariable("pubId") Integer pubId) {
		publicationService.deletePublication(pubId);
	}

	
	//@ApiOperation(value = "Récupérer la liste des publications triee")
	@GetMapping("/retrieve-all-publicationstriee")
	@ResponseBody
	public List<Publication> getPublicationstri() {
	return publicationService.findAllpublicationtri(); 
	}
	
	//@GetMapping("/retrieve-publication")
	//@ResponseBody
	//Optional<Publication> retrievePublication(String contents){
	//return publicationService.retrievePublication(contents);
	//}



	
	
	

}


	
	
	

