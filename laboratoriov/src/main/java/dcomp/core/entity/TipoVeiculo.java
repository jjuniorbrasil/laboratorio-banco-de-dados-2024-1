package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TipoVeiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    @Column(name = "peso_max")
    private float pesoMaximo;

}
