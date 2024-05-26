package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.service.ColetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequiredArgsConstructor
@RestController("/v1/coletas")
public class ColetaController {

    private final ColetaService coletaService;

    @GetMapping
    public String buscaTodasColetas(){
        return "OK";
    }
//    public ResponseEntity<?> buscaTodasColetas() {
//        coletaService.buscarTodasColetas();
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/agendamento")
    public ResponseEntity<?> agendaColeta(@RequestBody ColetaDTO coletaDTO) {
        //coletaService.agendarColeta(agendamentoDTO);
        return ResponseEntity.ok().build();
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
