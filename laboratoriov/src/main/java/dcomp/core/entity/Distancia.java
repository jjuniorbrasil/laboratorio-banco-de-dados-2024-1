package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "distancia")
public class Distancia implements EntidadeBase<DistanciaPK> {

    @Getter @EmbeddedId
    private DistanciaPK key = new DistanciaPK();

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_origem") @MapsId("cidadeOrigemId")
    private Cidade origem;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_destino") @MapsId("cidadeDestinoId")
    private Cidade destino;

    @Getter @Setter @Column(nullable = false)
    private int quilometros;

    public Distancia(int quilometros, Cidade cidadeOrigem, Cidade cidadeDestino) {
        this.quilometros = quilometros;
        this.destino = cidadeDestino;
        key.setCidadeOrigemId(cidadeOrigem.getId());
        key.setCidadeDestinoId(cidadeDestino.getId());
    }
}
