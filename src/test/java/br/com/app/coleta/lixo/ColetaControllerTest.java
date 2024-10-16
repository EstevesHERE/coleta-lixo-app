package br.com.app.coleta.lixo;

import br.com.app.coleta.lixo.controller.ColetaController;
import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.service.ColetaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class ColetaControllerTest {


    @InjectMocks
    private ColetaController coletaController;
    @Mock
    private ColetaService coletaService;


    @Test
    @DisplayName("Dado buscar todas as coletas, quando existente banco de dados então retornar status OK")
    void coletaControllerTest() {

        final var listResponseEntity = coletaController.buscaTodasColetas();
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    @DisplayName("Dado agendar coletas, quando dados validos então retornar status CREATED")
    void coletaAgendamentoControllerTest() {

        final var listResponseEntity = coletaController.agendaColeta(new ColetaDTO());
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    @DisplayName("Dado reagendamento coletas, quando id existente então retornar status NOCONTENT")
    void coletaReagendamentoControllerTest() {

        final var listResponseEntity = coletaController.reagendamentoColeta("10", new ColetaDTO());
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT));
    }


    @Test
    @DisplayName("Dado deletar agendamento coleta, quando id existente então retornar status NOCONTENT")
    void coletaDeletarControllerTest() {

        final var listResponseEntity = coletaController.delecaoAgendamento("10");
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT));
    }

}
