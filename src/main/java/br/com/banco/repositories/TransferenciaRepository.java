package br.com.banco.repositories;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.banco.models.TransferenciaModels;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModels,Id> {

    @Query("FROM TransferenciaModels WHERE nome_operador_transacao = ?1")
    List<TransferenciaModels> findByName(String nome_operador_transacao);

    @Query("FROM TransferenciaModels WHERE data_transferencia BETWEEN ?1 AND ?2")
    List<TransferenciaModels> findBeteewDate(LocalDate start, LocalDate end);

    @Query("FROM TransferenciaModels WHERE nome_operador_transacao = ?3 AND data_transferencia BETWEEN ?1 AND ?2 ")
    List<TransferenciaModels> findbyDateandName(LocalDate start, LocalDate end, String nome);

}
