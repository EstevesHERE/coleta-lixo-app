package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.dto.UsuarioCadastroDTO;
import br.com.app.coleta.lixo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;



}
