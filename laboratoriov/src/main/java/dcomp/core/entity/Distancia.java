package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "distancia")
public class Distancia implements EntidadeBase {

    @Getter @EmbeddedId
    private DistanciaPK key = new DistanciaPK();

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_origem") @MapsId("cidadeOrigemId")
    private Cidade Origem;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_destino") @MapsId("cidadeDestinoId")
    private Cidade Destino;

    @Getter @Setter @Column(nullable = false)
    private int quilometros;


    public Distancia(int quilometros, Cidade cidadeOrigem, Cidade cidadeDestino) {
        this.quilometros = quilometros;
        this.Destino = cidadeDestino;
        key.setCidadeOrigemId(cidadeOrigem.getId());
        key.setCidadeDestinoId(cidadeDestino.getId());
    }
}
