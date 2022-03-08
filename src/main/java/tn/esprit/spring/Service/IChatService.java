package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Chat;


public interface IChatService {
	public Chat addChat(Chat chat);
	public Chat updateChat(Chat chat);
	public void deleteChat(Integer chatId);
	public List<Chat>retrieveAllChats();
	public  Chat verifierword(Chat chat);
   public  String ajouterEtAffecterChat(Chat c ,Long Id);
//public List<Chat>retrieveAllChatsmatching(Chat c ,Long Id);
   
   public String rett(Chat c, Long Id);

    
    
}
