package br.com.app.coleta.lixo.dto;

public record UsuarioDTO(
        Long idUsuario,
        String nome,
        String email,
        String senha
) {}
