package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ColetaDTO {

    @JsonProperty("id_coleta")
    public long idColeta;
    @JsonProperty("nome_bairro")
    public String nomeBairro;
    public Date dataColeta;
    public Date dataRegistro;
    @JsonProperty("numero_volume")
    public double numeroVolume;

    public ColetaDTO(long idColeta, String nomeBairro, Date dataColeta, Date dataRegistro, double numeroVolume) {
        this.idColeta = idColeta;
        this.nomeBairro = nomeBairro;
        this.dataColeta = dataColeta;
        this.dataRegistro = dataRegistro;
        this.numeroVolume = numeroVolume;
    }
}
