package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import tn.esprit.spring.repositories.PublicationRepository;

import tn.esprit.spring.entities.Publication;

@Service
public class PublicationServiceImpl implements IPublicationService {

	@Autowired
	PublicationRepository publicationRepository;


	

	@Override
	public List<Publication> retrieveAllPublications() {
		return (List<Publication>) publicationRepository.findAll();
	
	}

	
	

	@Override
	public Publication addPublication(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public Publication updatePublication(Publication publication) {
		return publicationRepository.save(publication);
	}
	
		

	@Override
	public Optional<Publication> retrieveUserById(long pubId) {
		// TODO Auto-generated method stub
		return null;
	}

	




	@Override
	public void deletePublication(Integer pubId) {
		publicationRepository.deleteById(pubId);
		
	}




	@Override
	public List<Publication> findByContents(String contents) {
		return (List<Publication>) publicationRepository.findByContents(contents);
	}




	@Override
	public List<Publication> findByLastPublication(Date datePub, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Publication> findAllpublicationtri() {
		return  publicationRepository.findAllpublicationtri();
	}




	@Override
	public List<Publication> retrieveallPUblicationstriee(String pub) {
		// TODO Auto-generated method stub
		return null;
	}







	


	
	
	
}
