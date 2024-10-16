package br.com.app.coleta.lixo.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import static jakarta.persistence.GenerationType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tbl_rota")
public class Rota {
    @Id
    @NotNull
    @Column(name = "id_rota")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idRota;
    @NotNull
    @Column(name = "nome_rota")
    public String nomeRota;
    @NotNull
    @Column(name = "descricao_rota")
    public String descricaoRota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caminhao")
    public Caminhao caminhao;
}
