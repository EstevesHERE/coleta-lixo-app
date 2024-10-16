package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RotaDTO(
        @JsonProperty("id_rota")
        long idRota,
        @JsonProperty("nome_rota")
        String nomeRota,
        @JsonProperty("descricao_rota")
        String descricaoRota,
        CaminhaoDTO caminhao
) { }
