package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Likee;



public interface ILikeService {
	public Likee addLikee(Likee likee);
	public void ajouterEtaffecterlike(Likee likee,Integer pubId);
	public void ajouterEtaffecterlike(Likee likee,Integer pubId,Long userId);

	public Likee updateLikee(Likee l);
	
	void deleteLikee (Integer idlike);
}
