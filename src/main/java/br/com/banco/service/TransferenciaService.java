package br.com.banco.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.banco.models.TransferenciaModels;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransferenciaService {

	@Autowired
	 final TransferenciaRepository transferenciaRepository;
	public TransferenciaService(TransferenciaRepository transferenciaRepository) {
		this.transferenciaRepository = transferenciaRepository;
	}


	public TransferenciaModels save(TransferenciaModels transferencia) {
	    	return transferenciaRepository.save(transferencia);
	    }
	    
	    public List<TransferenciaModels> findAll() {
	        return transferenciaRepository.findAll();
	    }

		public List<TransferenciaModels> findAllByName(String nome_operador_transacao){
		return transferenciaRepository.findByName(nome_operador_transacao);
		}

		public List<TransferenciaModels> findAllByDate(LocalDate start, LocalDate end){
		return transferenciaRepository.findBeteewDate(start,end);
		}

		public List<TransferenciaModels> findAllNameandDate(LocalDate start, LocalDate end, String nome){
			return  transferenciaRepository.findbyDateandName(start,end,nome);
		}
	    
	    //public List<TransferenciaModels> findTransferenciasDateConta(Date TimeStart, Date TimeEnd, String nome){
	    	
	    	//List<TransferenciaModels> transferenciasdate = transferenciaRepository.findAllByPublicationTimeBetween(TimeStart, TimeEnd).;
	    	
	    	//List<TransferenciaModels> transferencia = transferenciasdate.
	    	
	    //}
	}

