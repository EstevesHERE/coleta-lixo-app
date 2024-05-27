package br.com.app.coleta.lixo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record UsuarioDTO(
        Long idUsuario,
        String nome,
        String email,
        String senha
) { }
