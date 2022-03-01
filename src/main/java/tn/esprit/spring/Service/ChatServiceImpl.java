package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ChatRepository;

import tn.esprit.spring.Entity.Chat;

@Service
public class ChatServiceImpl implements IChatService {
	@Autowired
	ChatRepository chatRepository;

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

	

	

}
