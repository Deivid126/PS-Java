package service;

import org.springframework.stereotype.Service;

import repositories.TransRepository;

@Service
public class TransService {
	
final TransRepository transRepository;
	
	public TransService(TransRepository transRepository) {
		this.transRepository = transRepository;
	}

}
