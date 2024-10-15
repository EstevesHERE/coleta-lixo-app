package br.com.app.coleta.lixo;

import br.com.app.coleta.lixo.controller.ColetaControllers;
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
public class ColetaControllersTest {


    @InjectMocks
    private ColetaControllers coletaControllers;
    @Mock
    private ColetaService coletaService;


    @Test
    @DisplayName("Dado buscar todas as coletas, quando existente banco de dados então retornar status OK")
    void coletaControllerTest() {

        final var listResponseEntity = coletaControllers.buscaTodasColetas();
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    @DisplayName("Dado agendar coletas, quando dados validos então retornar status CREATED")
    void coletaAgendamentoControllerTest() {

        final var listResponseEntity = coletaControllers.agendaColeta(new ColetaDTO());
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.CREATED));
    }

    @Test
    @DisplayName("Dado reagendamento coletas, quando id existente então retornar status NOCONTENT")
    void coletaReagendamentoControllerTest() {

        final var listResponseEntity = coletaControllers.reagendamentoColeta("10", new ColetaDTO());
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT));
    }


    @Test
    @DisplayName("Dado deletar agendamento coleta, quando id existente então retornar status NOCONTENT")
    void coletaDeletarControllerTest() {

        final var listResponseEntity = coletaControllers.delecaoAgendamento("10");
        assert (listResponseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT));
    }

}
