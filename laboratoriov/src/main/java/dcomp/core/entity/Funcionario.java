package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "funcionario")
@SuperBuilder
public class Funcionario extends PessoaFisica {

    @Getter @Column(nullable = false)
    private int matricula;

    @Getter @Setter @OneToMany(mappedBy = "tutor",cascade = CascadeType.ALL)
    private Set<Dependente> dependentes;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_filial")
    private Filial filial;

    public Funcionario (String nome, String cpf, String email, String telefone, int matricula, Set<Dependente> dependentes, Filial filial){
        super(nome,cpf,email,telefone);
        this.matricula = matricula;
        this.dependentes.addAll(!Objects.isNull(dependentes) ? dependentes : new LinkedHashSet<>());
        this.filial = filial;
    }

}
