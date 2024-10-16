package br.com.app.coleta.lixo.service;

import br.com.app.coleta.lixo.dto.ColetaDTO;
import br.com.app.coleta.lixo.models.Coleta;
import br.com.app.coleta.lixo.repository.ColetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColetaService {

    private final ColetaRepository coletaRepository;

    public List<ColetaDTO> buscarTodasColetas() {
        var listColeta = coletaRepository.findAll();
        return listColeta.stream().map(coleta -> new ColetaDTO(coleta.getIdColeta(), coleta.getNomeBairro(), coleta.getDataColeta(), coleta.getDataRegistro(), coleta.getNumeroVolume())).collect(Collectors.toList());
    }

    public void agendarColeta(ColetaDTO coletaDTO) {
        coletaRepository.save(new Coleta(coletaDTO.getNomeBairro(), coletaDTO.getNumeroVolume(), coletaDTO.dataColeta, coletaDTO.getDataRegistro()));
    }

    public void reagendarColeta(ColetaDTO coletaDTO, String idColeta) {
        coletaRepository.save(new Coleta(Long.valueOf(idColeta), coletaDTO.getNomeBairro(), coletaDTO.getNumeroVolume(), coletaDTO.dataColeta, coletaDTO.getDataRegistro(),null));
    }

    public void deletarColeta(String idColeta) {
        coletaRepository.deleteById(Long.valueOf(idColeta));
    }

}
