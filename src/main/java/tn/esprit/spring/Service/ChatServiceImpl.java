package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Chat;
import tn.esprit.spring.Entity.Matching;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.ChatRepository;
import tn.esprit.spring.Repository.MatchingRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class ChatServiceImpl implements IChatService {
	@Autowired
	ChatRepository chatRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MatchingRepository MR;
	@Override
	public Chat addChat(Chat chat) {
		return chatRepository.save(chat);
	}

	@Override
	public Chat updateChat(Chat chat) {
		return chatRepository.save(chat);
	}


	public List<Chat> retrieveAllChats() {
		return (List<Chat>) chatRepository.findAll();
	}

	@Override
	public void deleteChat(Integer chatId) {
		chatRepository.deleteById(chatId);
		
	}

	@Override
	public Chat verifierword(Chat chat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public  String ajouterEtAffecterChat(Chat c, Long Id) {
	

	
	List<Matching> lu1 = new ArrayList<Matching>();
	List<Matching> lu2 = new ArrayList<Matching>();
	User user = userRepository.findById((long) Id).orElse(null);
	User user2 =userRepository.findById(c.getUserr().getId()).orElse(null);
	System.out.println("user2"+user2.getId());
	System.out.println("useer1"+user.getId());
	
	c.setUser(user);

	Matching M =MR.findByUser1AndUser2(user,user2);
	Matching M2=MR.findByUser2AndUser1(user, user2);
	if(M==null){
	if(M2.getMatchuser1().equals("yes") && M2.getMatchuser2().equals("yes")){

	chatRepository.save(c);
	return "Ajouter Avec Success";
	}else
	return "Ajout Impossible ";
	}
	else
	if(M2==null){
	if(M.getMatchuser1().equals("yes") && M.getMatchuser2().equals("yes")){

	chatRepository.save(c);
	return "Ajouter Avec Success";
	}else
	return "Ajout Impossible ";
	}
	else{
	if(M.getMatchuser1().equals("yes") && M.getMatchuser2().equals("yes")){

	chatRepository.save(c);
	return "Ajouter Avec Success";
	}else
	return "Ajout Impossible ";
	}}

	@Override
	public String rett(Chat c, Long Id) {
		User user = userRepository.findById((long)Id).orElse(null);
		User user2 =userRepository.findById(c.getUserr().getId()).orElse(null);
		System.out.println("user2"+user2.getId());
		System.out.println("useer1"+user.getId());
		c.setUser(user);
		
		
		Matching M = MR.findByUser1AndUser2(user, user2);
		Matching M2 = MR.findByUser2AndUser1(user, user2);
		return (""+M);
	}
			

}


		

	//@Override
	//public List<Chat> retrieveAllChatsmatching(Chat c, Long Id) {
		
	//	User user = userRepository.findById((long)Id).orElse(null);
		//User user2 =userRepository.findById((long)Id).orElse(null);
	
		//System.out.println(user);
		//Matching M = MR.findUser1AndUser2(user, user2);
	//	System.out.println(M.getMatchuser1());
		//System.out.println(M.getMatchuser2());
//		if(M.getMatchuser1().equals("yes")&& M.getMatchuser2().equals("yes")){
			//chatRepository.findalluser();
			//}
		//return  chatRepository.findalluser();
	//	}

	
	

