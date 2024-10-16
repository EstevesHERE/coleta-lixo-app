package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.dto.UsuarioDTO;
import br.com.app.coleta.lixo.models.Usuario;
import br.com.app.coleta.lixo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> buscaUsuario(@PathVariable String idUsuario) {
        var usuario = usuarioService.buscarUsuarioPorID(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> delecaoUsuario(@PathVariable String idUsuario) {
        usuarioService.deletarUsuario(idUsuario);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
