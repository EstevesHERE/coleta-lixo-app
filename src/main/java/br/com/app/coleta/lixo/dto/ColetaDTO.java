package br.com.app.coleta.lixo.dto;

import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class ColetaDTO {
    public long id_coleta;
    public String nome_bairro;
    public Date dataColeta;
    public Date dataRegistro;
    public double numero_volume;
    public RotaDTO rota;
}
