package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Badge;
import tn.esprit.spring.Entity.User;

public interface IUserService {
	
	public List<String> SearchByName(String firstName, String lastName);
	
	public List<String> SearchByDomain(String nameDomain);
	
	public Badge AffectBadge(User user);

}
