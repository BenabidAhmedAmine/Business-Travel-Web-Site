package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;

public interface ClientSerivce {
	
  List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	List<Client> getClientsBydateNaissanceJpql(Date date1, Date date2);
	
	List<Client> retrieveClientsBydateNaissanceSql( Date date1, Date date2);
	
	List<Client> retrieveClientsByProfessionJpql( Profession profession);
}
