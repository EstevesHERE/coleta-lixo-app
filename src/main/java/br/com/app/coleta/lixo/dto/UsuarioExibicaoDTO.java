package br.com.app.coleta.lixo.dto;

import br.com.app.coleta.lixo.models.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail());
    }

}
