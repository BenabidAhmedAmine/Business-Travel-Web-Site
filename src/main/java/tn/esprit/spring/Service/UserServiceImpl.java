package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Badge;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Badge AffectBadge(User user) {
		long id = user.getUserId(); 
		long count= userRepository.countBySubscriptionsUsersUserId(id);
		if (count <= 5){
			return Badge.Bronze;
		}else if(count <= 10 && count < 5){
			return Badge.Silver;
		}else{
			return Badge.Gold;
		}
		
		
	}

	@Override
	public List<String> SearchByName(String firstName, String lastName) {
		
		List<User> lusers=userRepository.findByFirstNameOrLastNameLike(firstName, lastName);
		List<String> lnames= new ArrayList<String>();
		for(User user :lusers){
			lnames.add(user.getFirstName());
			lnames.add(user.getLastName());
			
		}
		return lnames ;
	}

	@Override
	public List<String> SearchByDomain(String nameDomain) {
		List<User> lusers=userRepository.findByDomainActivityName(nameDomain);
		List<String> lnames= new ArrayList<String>();
		for(User user :lusers){
			lnames.add(user.getLastName());
			
		}
		return lnames ;
	}

	
}
