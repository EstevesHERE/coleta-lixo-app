package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CaminhaoDTO (
        @JsonProperty("id_caminhao")
        long idCaminhao,
        String modelo,
        @JsonProperty("numero_capacidade")
        int numeroCapacidade,
        @JsonProperty("numero_max_capacidade")
        int numeroMaximoCapacidade,
        @JsonProperty("nome_status")
        String nomeStatus
) { }
