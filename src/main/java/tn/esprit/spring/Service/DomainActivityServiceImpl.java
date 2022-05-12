package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.DomainActivity;
import tn.esprit.spring.Repository.DomainActivityRepository;

@Service
public class DomainActivityServiceImpl implements IDomainActivityService {
	
	
	@Autowired
	DomainActivityRepository domainActivityRepository;

	@Override
	public DomainActivity addDomainActivity(DomainActivity d) {
		
		return domainActivityRepository.save(d);
	}

}
