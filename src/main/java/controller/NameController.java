package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.NameService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/conta")
public class NameController {

	final NameService nameService;
	
	public NameController(NameService nameService) {
		this.nameService = nameService;
	}
	
	
	
	
	
}
