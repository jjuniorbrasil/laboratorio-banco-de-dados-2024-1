package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Pessoa_fisica")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor
public class PessoaFisica {
    @Id
    @Getter
    private String cpf;

    @Getter  @Column(nullable = false)
    private String nome;


    @Getter @Setter @Column(nullable = false)
    private String email;

    @Getter @Setter @Column(nullable = false)
    private String telefone;
}
