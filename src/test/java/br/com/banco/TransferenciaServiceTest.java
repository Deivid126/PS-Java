package br.com.banco;

import br.com.banco.exception.BusinessException;
import br.com.banco.models.TransferenciaModels;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ch.qos.logback.core.util.OptionHelper.isEmpty;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class TransferenciaServiceTest {

    @Mock
    TransferenciaRepository transferenciaRepository;

    @InjectMocks
    TransferenciaService transferenciaService;


    @Test
    public void GetbyNameTest() throws BusinessException {


        TransferenciaModels transferenciaModels = new TransferenciaModels();
        transferenciaModels.setNome_operador_transacao("Roberto");

        Mockito.when(transferenciaRepository.findByName(transferenciaModels.getNome_operador_transacao())).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllByName(transferenciaModels.getNome_operador_transacao());

        Mockito.verify(transferenciaRepository).findByName(transferenciaModels.getNome_operador_transacao());


    }

    @Test
    public void GetByDate() throws BusinessException {

        TransferenciaModels transferenciaModels = new TransferenciaModels();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse("2004-02-23");
        LocalDate fim = LocalDate.parse("2004-03-23");

        Mockito.when(transferenciaRepository.findBeteewDate(inicio,fim)).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllByDate(inicio,fim);

        Mockito.verify(transferenciaRepository).findBeteewDate(inicio,fim);
    }
    @Test
    public void GetByDateandName() throws Exception {
        TransferenciaModels transferenciaModels = new TransferenciaModels();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse("2004-02-23");
        LocalDate fim = LocalDate.parse("2004-03-23");
        transferenciaModels.setNome_operador_transacao("Roberto");

        Mockito.when(transferenciaRepository.findbyDateandName(inicio,fim,transferenciaModels.getNome_operador_transacao())).thenReturn(List.of(transferenciaModels));

        transferenciaService.findAllNameandDate(inicio,fim,transferenciaModels.getNome_operador_transacao());

        Mockito.verify(transferenciaRepository).findbyDateandName(inicio,fim,transferenciaModels.getNome_operador_transacao());

    }
    @Test
    public void GetByNameEror() throws BusinessException {

        TransferenciaModels transferenciaModels = new TransferenciaModels();
        transferenciaModels.setNome_operador_transacao("Roberto");

        Mockito.when(transferenciaRepository.findByName(transferenciaModels.getNome_operador_transacao())).thenReturn(List.of());


        BusinessException businessException = assertThrows(BusinessException.class,() -> {
            transferenciaService.findAllByName(transferenciaModels.getNome_operador_transacao());
        });

        Assertions.assertThat(businessException.getMessage()).isEqualTo("Transferências não encontradas");

    }
    @Test
    public void GetDateError(){
        TransferenciaModels transferenciaModels = new TransferenciaModels();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse("2004-02-23");
        LocalDate fim = LocalDate.parse("2004-03-23");
        transferenciaModels.setNome_operador_transacao("Roberto");

        Mockito.when(transferenciaRepository.findBeteewDate(inicio,fim)).thenReturn(List.of());

        BusinessException businessException = assertThrows(BusinessException.class,() -> {
            transferenciaService.findAllByDate(inicio,fim);
        });

        Assertions.assertThat(businessException.getMessage()).isEqualTo("Não existem transferências com esse intercalo de tempo");
    }

        @Test
        public void GetAllNameandDateError(){
            TransferenciaModels transferenciaModels = new TransferenciaModels();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inicio = LocalDate.parse("2004-02-23");
            LocalDate fim = LocalDate.parse("2004-03-23");
            transferenciaModels.setNome_operador_transacao("Roberto");

            Mockito.when(transferenciaRepository.findbyDateandName(inicio,fim,transferenciaModels.getNome_operador_transacao())).thenReturn(List.of());

            BusinessException businessException = assertThrows(BusinessException.class,() -> {
                transferenciaService.findAllNameandDate(inicio,fim,transferenciaModels.getNome_operador_transacao());
            });

            Assertions.assertThat(businessException.getMessage()).isEqualTo("Transferências não encontradas");


        }


}
