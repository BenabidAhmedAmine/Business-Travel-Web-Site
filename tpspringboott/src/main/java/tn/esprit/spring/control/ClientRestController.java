package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientSerivce;

@RestController
@RequestMapping("/client")
@Api(tags = "Client management")
public class ClientRestController {
	@Autowired
	ClientSerivce clientService;
	// http://localhost:8087/SpringMVC/client/retrieve-all-clients
	@ApiOperation(value = "Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;}
	
	// http://localhost:8087/SpringMVC/client/retrieve-client/1
	@ApiOperation(value = "Récupérer client par id")
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	return clientService.retrieveClient(clientId);
	}
	
	// http://localhost:8087/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c)
	{
	Client client = clientService.addClient(c);
	return client;
	}
	
	// http://localhost:8087/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.deleteClient(clientId);
	}
	
	// http://localhost:8087/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}

}
