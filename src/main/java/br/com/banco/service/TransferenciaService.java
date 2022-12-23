package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;
import br.com.banco.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.models.TransferenciaModels;
import br.com.banco.repositories.TransferenciaRepository;


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

		public List<TransferenciaModels> findAllByName(String nome) throws BusinessException {

		List<TransferenciaModels> transferencias = transferenciaRepository.findByName(nome);

		if(transferencias.isEmpty()) {
			throw new BusinessException("Transferências não encontradas");
		}

		return transferencias;
		}

		public List<TransferenciaModels> findAllByDate(LocalDate start, LocalDate end) throws BusinessException {
		List<TransferenciaModels> transferenciaByDate = transferenciaRepository.findBeteewDate(start,end);

		if(transferenciaByDate.isEmpty()){
			throw new BusinessException("Não existem transferências com esse intercalo de tempo");
		}
		return transferenciaByDate;
		}

		public List<TransferenciaModels> findAllNameandDate(LocalDate start, LocalDate end, String nome) throws BusinessException {

			List<TransferenciaModels> transferencias = transferenciaRepository.findbyDateandName(start,end,nome);

			if(transferencias.isEmpty()){
				throw new BusinessException("Transferências não encontradas");
			}
			return  transferencias;
		}

	}

