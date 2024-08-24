package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "veiculo")
public class Veiculo implements EntidadeBase<VeiculoPK> {
    @EmbeddedId @Getter
    private VeiculoPK key = new VeiculoPK();

    @Getter @Setter @ManyToOne @MapsId("filialId") @JoinColumn(name = "id_filial")
    private Filial filial;

    @Getter @Setter  @ManyToOne @JoinColumn(name = "id_tipo")
    private TipoVeiculo tipo;

    public Veiculo( Filial filial, TipoVeiculo tipo) {
        this.filial = filial;
        this.tipo = tipo;
        key.setFilialId(filial.getId());
    }
}
