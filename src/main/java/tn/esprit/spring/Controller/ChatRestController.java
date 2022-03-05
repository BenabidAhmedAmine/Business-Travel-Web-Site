package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javamaster.storage.UserStorage;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Service.ChatServiceImpl;
import tn.esprit.spring.BadWordFilter;
import tn.esprit.spring.Entity.Chat;



@RequestMapping("/chat")
@RestController
public class ChatRestController {
	
	
	@Autowired
	ChatServiceImpl chatService;
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Chat message) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists) {
        //	message.setMessage( BadWordFilter.getCensoredText(message.getMessage() ));
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
	
	
	@ApiOperation(value = "Ajouter chat ")
	@PostMapping("/add-chat")
	@ResponseBody
	public Chat addChat(@RequestBody Chat chat)
	{
		Chat c  = chatService.addChat(chat);
	return c;

}
	

	
	
	@GetMapping("/retrieve-all-chats")
	@ResponseBody
	public List<Chat> getChats() {
	List<Chat> listChats= chatService.retrieveAllChats();
	return listChats;
	}

}
