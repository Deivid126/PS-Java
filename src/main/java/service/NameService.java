package service;

import org.springframework.stereotype.Service;

import repositories.NameRepository;

@Service
public class NameService {

	final NameRepository nameRepository;
	
	public NameService(NameRepository nameRepository) {
		this.nameRepository = nameRepository;
	}
	
}
	
