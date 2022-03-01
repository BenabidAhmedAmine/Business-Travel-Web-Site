package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Chat;


public interface IChatService {
	public Chat addChat(Chat chat);
	public Chat updateChat(Chat chat);
	public void deleteChat(Integer chatId);
	public List<Chat>retrieveAllChats();
	public  Chat verifierword(Chat chat);

}
