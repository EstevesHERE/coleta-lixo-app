package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.models.Coleta;
import br.com.app.coleta.lixo.service.ColetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity agendaColeta(@RequestBody ColetaDTO coletaDTO) {
        coletaService.agendarColeta(coletaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/agendamento/{idColeta}")
    public ResponseEntity<?> reagendamentoColeta(@PathVariable String idColeta) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/agendamento/{idColeta}")
    public ResponseEntity<?> delecaoAgendamento(@PathVariable String idColeta) {
        return ResponseEntity.ok().build();
    }
}
