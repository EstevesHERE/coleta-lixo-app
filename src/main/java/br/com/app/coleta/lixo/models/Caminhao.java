package br.com.app.coleta.lixo.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "tbl_caminhao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao {

    @Id
    @Column(name = "id_caminhao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idCaminhao;
    @NotNull
    public String modelo;
    @NotNull
    @Column(name = "numero_capacidade")
    public int numeroCapacidade;
    @NotNull
    @Column(name = "numero_max_capacidade")
    public int numeroMaxCapacidade;
    @NotNull
    @Column(name = "nome_status")
    public Status nomeStatus;
}
