package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TipoVeiculo implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Column(name = "peso_max")
    private float pesoMaximo;

    @Override
    public Integer getKey() {
        return this.id;
    }
}
