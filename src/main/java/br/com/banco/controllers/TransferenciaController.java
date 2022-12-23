package br.com.banco.controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.banco.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.banco.models.TransferenciaModels;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transferencia")
public class TransferenciaController {

	@Autowired
	final TransferenciaService transferenciaservice;

	public TransferenciaController(TransferenciaService transferenciaservice) {
		this.transferenciaservice = transferenciaservice;
	}


	//@PostMapping
   // public ResponseEntity<TransferenciaModels> salvartransferencia(){
        

        //return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaservice.save(transferencia));
   // }

	
	@GetMapping
	public ResponseEntity<List<TransferenciaModels>> Get(){
		
		return ResponseEntity.status(HttpStatus.OK).body(transferenciaservice.findAll());
	}

	@GetMapping("/{nome_operador_transacao}")
	public ResponseEntity<List<TransferenciaModels>> GetbyName(@PathVariable(value = "nome_operador_transacao") String nome_operador) throws BusinessException {

			List<TransferenciaModels> transferencias = transferenciaservice.findAllByName(nome_operador);


			return ResponseEntity.status(HttpStatus.OK).body(transferencias);
	}
	@GetMapping("/{start}/{end}")
	public ResponseEntity<List<TransferenciaModels>> GetByDate(@PathVariable String start, @PathVariable String end) throws BusinessException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate inicio = LocalDate.parse(start, formatter);
		LocalDate fim = LocalDate.parse(end,formatter);

		return ResponseEntity.status(HttpStatus.OK).body(transferenciaservice.findAllByDate(inicio,fim));
	}
	@GetMapping("/{start}/{end}/{nome}")
	public ResponseEntity<List<TransferenciaModels>> GetNameandDate(@PathVariable String start, @PathVariable String end, @PathVariable String nome) throws BusinessException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate inicio = LocalDate.parse(start, formatter);
		LocalDate fim = LocalDate.parse(end,formatter);

		return  ResponseEntity.status(HttpStatus.OK).body(transferenciaservice.findAllNameandDate(inicio,fim,nome));
	}
	}
