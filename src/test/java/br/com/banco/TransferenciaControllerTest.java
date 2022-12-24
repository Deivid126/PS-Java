package br.com.banco;


import br.com.banco.exception.BusinessException;
import br.com.banco.models.TransferenciaModels;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TransferenciaControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    TransferenciaService transferenciaService;

    @MockBean
    TransferenciaRepository transferenciaRepository;



    @Test
    public void transferenciaGetAllOK() throws Exception {

        TransferenciaModels transferenciaModels = new TransferenciaModels();

        Mockito.when(transferenciaRepository.findAll()).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/transferencia")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void transferenciaGetByName() throws Exception {
        TransferenciaModels transferenciaModels = new TransferenciaModels();
        transferenciaModels.setNome_operador_transacao("Ronnyscley");
        Mockito.when(transferenciaRepository.findByName(transferenciaModels.getNome_operador_transacao())).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllByName(transferenciaModels.getNome_operador_transacao());

        mockMvc.perform(MockMvcRequestBuilders.get("/transferencia/{nome_operador_transacao}","Ronnyscley")).andExpect(MockMvcResultMatchers.status().isOk());


    }
    @Test
    public void transferenciaGeybyDate() throws Exception {

        TransferenciaModels transferenciaModels = new TransferenciaModels();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse("2004-02-23",formatter);
        LocalDate fim = LocalDate.parse("2004-03-23",formatter);

        Mockito.when(transferenciaRepository.findBeteewDate(inicio,fim)).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllByDate(inicio,fim);

        mockMvc.perform(MockMvcRequestBuilders.get("/transferencia/{start}/{end}",inicio,fim)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void GetAllDateendNameStatusOk() throws Exception {
        TransferenciaModels transferenciaModels = new TransferenciaModels();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse("2004-02-23",formatter);
        LocalDate fim = LocalDate.parse("2004-03-23",formatter);
        transferenciaModels.setNome_operador_transacao("Deivid");

        Mockito.when(transferenciaRepository.findbyDateandName(inicio,fim,transferenciaModels.getNome_operador_transacao())).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllNameandDate(inicio,fim,transferenciaModels.getNome_operador_transacao());

        mockMvc.perform(MockMvcRequestBuilders.get("/transferencia/{start}/{end}/{name}",inicio,fim,transferenciaModels.getNome_operador_transacao())).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
