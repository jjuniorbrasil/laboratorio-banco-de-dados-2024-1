package ifma.laboratorioiv.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Profissionais")
public class Profissional implements BaseEntity {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Getter
    private Integer id;

    @Getter @Column(nullable = false)
    private String nome;

    @Getter @Column(nullable = false)
    private String telefone1;

    @Getter @Setter
    private String telefone2;

    @Getter @Setter
    private String observacao;

    @Getter @Embedded
    private Profissao profissao;
}
