package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Table(name = "pessoa_fisica")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public abstract class PessoaFisica implements EntidadeBase<String> {
    @Id @Getter
    private String cpf;

    @Getter  @Column(nullable = false)
    private String nome;

    @Getter @Setter @Column(nullable = false)
    private String email;

    @Getter @Setter @Column(nullable = false)
    private String telefone;

    @Override
    public String getKey() {
        return cpf;
    }
}
