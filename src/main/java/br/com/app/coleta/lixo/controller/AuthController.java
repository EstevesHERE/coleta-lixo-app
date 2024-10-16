package br.com.app.coleta.lixo.controller;

import br.com.app.coleta.lixo.advice.config.security.TokenService;
import br.com.app.coleta.lixo.dto.LoginDTO;
import br.com.app.coleta.lixo.dto.TokenDTO;
import br.com.app.coleta.lixo.dto.UsuarioCadastroDTO;
import br.com.app.coleta.lixo.dto.UsuarioExibicaoDTO;
import br.com.app.coleta.lixo.models.Usuario;
import br.com.app.coleta.lixo.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final UsuarioService usuarioService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO usuarioDTO) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDTO.email(),
                        usuarioDTO.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO) {
        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = usuarioService.salvarUsuario(usuarioCadastroDTO);
        return usuarioSalvo;

    }
}
