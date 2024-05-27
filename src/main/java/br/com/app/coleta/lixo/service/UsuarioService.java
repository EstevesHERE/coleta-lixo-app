package br.com.app.coleta.lixo.service;


import br.com.app.coleta.lixo.dto.UsuarioCadastroDTO;
import br.com.app.coleta.lixo.dto.UsuarioDTO;
import br.com.app.coleta.lixo.dto.UsuarioExibicaoDTO;
import br.com.app.coleta.lixo.models.Coleta;
import br.com.app.coleta.lixo.models.Usuario;
import br.com.app.coleta.lixo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioExibicaoDTO(usuarioSalvo);
    }

    public UsuarioDTO buscarUsuarioPorID(String idUsuario) {
        var usuario = usuarioRepository.findById(Long.valueOf(idUsuario)).orElse(null);
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), null);
    }

    public void deletarUsuario(String idUsuario) {
        usuarioRepository.deleteById(Long.valueOf(idUsuario));
    }


}
