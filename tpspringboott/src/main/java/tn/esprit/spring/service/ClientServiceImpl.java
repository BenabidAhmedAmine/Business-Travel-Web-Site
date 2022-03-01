package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.repository.ClientRepository;
@Slf4j
@Service
public class ClientServiceImpl implements ClientSerivce {
	
@Autowired
private ClientRepository clientRepository;

public List<Client> retrieveAllClients()
{
	log.info("In retrieveAllClients");
	return (List<Client>) clientRepository.findAll();
}

public Client addClient(Client c)
{
	log.info("In addClient");
	return clientRepository.save(c);
}

public void deleteClient(Long id){
	log.info("In deleteClient");
	log.warn("Attention,vous etes sur de supprimer ce client");
	clientRepository.deleteById(id);
}

public Client updateClient(Client c){
	log.info("In updateClient");
	return clientRepository.save(c);
}

public Client retrieveClient(Long id){
	log.info("In retrieveClient");
	return clientRepository.findById(id).orElse(null);
}
public List<Client> getClientsBydateNaissanceJpql(Date date1, Date date2)
{
	log.info("In getClientsBydateNaissanceJpql");
	return clientRepository.retrieveClientsBydateNaissanceJpql(date1, date2);
}

@Override
public List<Client> retrieveClientsBydateNaissanceSql(Date date1, Date date2) {
	// TODO Auto-generated method stub
	log.info("In retrieveClientsBydateNaissanceSql");
	return clientRepository.retrieveClientsBydateNaissanceSql(date1, date2);
}

@Override
public List<Client> retrieveClientsByProfessionJpql(Profession profession) {
	// TODO Auto-generated method stub
	log.info("In retrieveClientsByProfessionJpql");
	return clientRepository.retrieveClientsByProfessionJpql(profession);
}
}
