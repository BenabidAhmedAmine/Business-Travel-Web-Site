package tn.esprit.spring;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.service.ClientSerivce;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImpTest {
	@Autowired
	ClientSerivce clientService;
	@Test
	public void testaddClient() throws ParseException{
		SimpleDateFormat date =new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = date.parse("30/01/2000");
		Client c = new Client();
		c.setNom("sami");
		c.setPrenom("ahmed");
		c.setEmail("sami.ahmed@esprit.tn");
		c.setPassword("1234");
		c.setDateNaissance(dateNaissance);
		c.setCategorieClient(CategorieClient.fidele);
		c.setProfession(Profession.ingénieur);
		Client client = clientService.addClient(c);
		
		assertNotNull(client.getIdClient());
		assertNotNull(client.getCategorieClient());
		assertTrue(client.getNom().length()>0);
		clientService.deleteClient(client.getIdClient());
	}
	@Test
	public void testdeleteClient() throws ParseException
	{
		List<Client> Clients=clientService.retrieveAllClients();
		int expected=Clients.size();
		SimpleDateFormat date =new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = date.parse("30/01/2000");
		Client c = new Client();
		c.setNom("sami");
		c.setPrenom("ahmed");
		c.setEmail("sami.ahmed@esprit.tn");
		c.setPassword("1234");
		c.setDateNaissance(dateNaissance);
		c.setCategorieClient(CategorieClient.fidele);
		c.setProfession(Profession.ingénieur);
		Client client = clientService.addClient(c);
		clientService.deleteClient(client.getIdClient());
		assertEquals(expected, clientService.retrieveAllClients().size());
		assertNull(clientService.retrieveClient(client.getIdClient()));
	}

}
