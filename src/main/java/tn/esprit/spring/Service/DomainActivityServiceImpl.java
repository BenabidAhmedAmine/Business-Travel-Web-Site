package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.esprit.spring.Entity.DomainActivity;
import tn.esprit.spring.Repository.DomainActivityRepository;

@Service
public class DomainActivityServiceImpl implements IDomainActivityService {

	@Autowired
	DomainActivityRepository domainActivityRepository;

	@Autowired
	IDictionaryUtilityService dict;
	

	@Override
	public DomainActivity addDomainActivity(DomainActivity d) {
		String name = d.getName();
		List<String> l = dict.getSynonyms(name);
		l.add(name);
		if (domainActivityRepository.findByNameIn(l).size() == 0) {
			return domainActivityRepository.save(d);
		} else {
			return null;
		}
	}
	


}
