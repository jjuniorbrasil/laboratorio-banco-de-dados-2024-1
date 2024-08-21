package dcomp.core.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Distancia {

    @EmbeddedId
    private DistanciaPK key = new DistanciaPK();

    private Cidade Destino;

    private int quilometros;


    public Distancia(int quilometros, Cidade cidadeOrigem, Cidade cidadeDestino) {
        this.quilometros = quilometros;
        this.Destino = cidadeDestino;
        key.setCidadeOrigemid(cidadeOrigem.getId());
        key.setCidadeDestinoid(cidadeDestino.getId());
    }
}
