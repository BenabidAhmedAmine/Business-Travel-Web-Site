package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DictionaryUtilityServiceImpl implements IDictionaryUtilityService {

	@Override
	public List<String> getSynonyms(String word) {
		String url = "http://localhost:9393/SpringDic/Dictionary/retrieve-synonyms/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> call = restTemplate.getForEntity(url + word, List.class, word);
		return call.getBody();

	}

	
}
