package br.com.app.coleta.lixo.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tbl_coleta")
public class Coleta {
    @Id
    @Column(name = "id_coleta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idColeta;
    @NotNull
    @Column(name = "nome_bairro")
    public String nomeBairro;
    @NotNull
    @Column(name = "numero_volume")
    public double numeroVolume;
    @NotNull
    @Column(name = "data_coleta")
    public Date dataColeta;
    @NotNull
    @Column(name = "data_registro")
    public Date dataRegistro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rota")
    public Rota rota;
}
