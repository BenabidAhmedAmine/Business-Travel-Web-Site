package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Dislike;
import tn.esprit.spring.Entity.Likee;


public interface IDislikeService {

	public Dislike addDislike(Dislike dislike);
	public void ajouterEtaffecterdislike(Dislike d,Integer pubId);
	public void ajouterEtaffecterlike(Dislike d,Integer pubId,Long Id);

	
	void deleteDislike (Integer iddislike);
	
	
	
	
	
	
	
	
	
	
	
	
}
