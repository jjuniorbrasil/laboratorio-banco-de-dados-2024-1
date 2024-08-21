package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaFrete implements EntidadeBase {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter @Column(nullable = false)
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter @Column(name = "percentual_adicional",nullable = false)
    private float percentualAdicional;
}
