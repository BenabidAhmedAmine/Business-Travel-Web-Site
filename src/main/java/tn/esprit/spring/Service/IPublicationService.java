package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import tn.esprit.spring.Entity.Publication;



public interface IPublicationService {
	public List<Publication>retrieveAllPublications();
	void deletePublication (Integer pubId);
	public Optional<Publication> retrieveUserById(long pubId);
	//public Publication retrieveUserByName (Long pubId);
	public Publication addPublication(Publication publication);
	public Publication updatePublication(Publication publication);
	//public List<Publication> findByContents(String contents);
//	Optional<Publication> retrievePublication(String contents);
	public List<Publication> findByLastPublication(Date datePub, Sort sort); 
public 	List<Publication> findAllpublicationtri();

public 	List<Publication> retrieveallPUblicationstriee(String pub);
public void	ajouterEtaffecterListePublication(Publication publication, Long  userId);
}
