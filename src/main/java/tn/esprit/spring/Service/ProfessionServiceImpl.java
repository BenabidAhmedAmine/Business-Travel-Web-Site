package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Profession;
import tn.esprit.spring.Repository.ProfessionRepository;
@Service
public class ProfessionServiceImpl implements IProfessionService {
	
	@Autowired
	ProfessionRepository  professionRepository;

	@Override
	public Profession addProfession(Profession p) {
		
		return professionRepository.save(p);
	}

}
