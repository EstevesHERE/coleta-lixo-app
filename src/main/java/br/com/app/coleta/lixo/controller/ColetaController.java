package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.models.Coleta;
import br.com.app.coleta.lixo.service.ColetaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/coletas")
public class ColetaController {

    private final ColetaService coletaService;
    @GetMapping
    public ResponseEntity<List<ColetaDTO>> buscaTodasColetas() {
        var listaColetas = coletaService.buscarTodasColetas();
        return ResponseEntity.status(HttpStatus.OK).body(listaColetas);
    }

    @PostMapping("/agendamento")
    public ResponseEntity<?> agendaColeta(@RequestBody @Valid ColetaDTO coletaDTO) {
        coletaService.agendarColeta(coletaDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/agendamento/{idColeta}")
    public ResponseEntity reagendamentoColeta(@PathVariable String idColeta, @RequestBody ColetaDTO coletaDTO) {
        coletaService.reagendarColeta(coletaDTO, idColeta);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @DeleteMapping("/agendamento/{idColeta}")
    public ResponseEntity delecaoAgendamento(@PathVariable String idColeta) {
        coletaService.deletarColeta(idColeta);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping("/agendamento/{idColeta}")
    public ResponseEntity<Coleta> buscaColeta(@PathVariable String idColeta) {
        var coleta = coletaService.buscarColeta(idColeta);
        return ResponseEntity.status(OK).body(coleta);
    }
}
