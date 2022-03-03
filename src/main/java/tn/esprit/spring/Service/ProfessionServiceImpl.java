package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Profession;
import tn.esprit.spring.Repository.DomainActivityRepository;
import tn.esprit.spring.Repository.ProfessionRepository;
@Service
public class ProfessionServiceImpl implements IProfessionService {
	
	@Autowired
	ProfessionRepository  professionRepository;
	
	@Autowired
	DomainActivityRepository domainActivityRepository;
	
	@Autowired
	IDictionaryUtilityService dict;

	@Override
	public Profession addProfession(Profession p) {
		
		String name = p.getName();
		List<String> l = dict.getSynonyms(name);
		l.add(name);
		if (professionRepository.findByNameIn(l).size() == 0) {
			return professionRepository.save(p);
		} else {
			return null;
		}
	}
	

}
