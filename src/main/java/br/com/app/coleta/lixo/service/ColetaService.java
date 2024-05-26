package br.com.app.coleta.lixo.service;

import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.models.Coleta;
import br.com.app.coleta.lixo.repository.ColetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColetaService {

    private final ColetaRepository coletaRepository;

    public List<Coleta> buscarTodasColetas() {
        var listColeta = coletaRepository.findAll();
        return listColeta;
    }

    public void agendarColeta(ColetaDTO coletaDTO) {

    }

    public void reagendarColeta() {

    }

    public void deletarColeta(Long idColeta) {
        coletaRepository.deleteById(idColeta);

    }

}
