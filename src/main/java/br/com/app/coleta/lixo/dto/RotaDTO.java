package br.com.app.coleta.lixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RotaDTO {

    @JsonProperty("id_rota")
    public long idRota;
    @JsonProperty("nome_rota")
    public String nomeRota;
    @JsonProperty("descricao_rota")
    public String descricaoRota;
    public CaminhaoDTO caminhao;
}
