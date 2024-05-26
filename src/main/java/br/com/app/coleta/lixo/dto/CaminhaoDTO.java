package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaminhaoDTO {

    @JsonProperty("id_caminhao")
    public long idCaminhao;
    public String modelo;
    @JsonProperty("numero_capacidade")
    public int numeroCapacidade;
    @JsonProperty("numero_max_capacidade")
    public int numeroMaximoCapacidade;
    @JsonProperty("nome_status")
    public String nomeStatus;
}
