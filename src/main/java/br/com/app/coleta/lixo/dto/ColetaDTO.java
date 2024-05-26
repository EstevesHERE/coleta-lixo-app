package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ColetaDTO {

    @JsonProperty("id_coleta")
    public long idColeta ;

    @JsonProperty("nome_bairro")
    public String nomeBairro;
    public Date dataColeta;
    public Date dataRegistro;
    @JsonProperty("numero_volume")
    public double numeroVolume;
    public RotaDTO rota;
}
