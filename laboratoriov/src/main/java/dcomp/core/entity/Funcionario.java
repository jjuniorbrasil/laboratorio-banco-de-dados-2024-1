package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Funcionario extends PessoaFisica {

    @EmbeddedId @Getter
    private FuncionarioPK key = new FuncionarioPK();

    @Getter @Column(nullable = false)
    private int matricula;

    @Getter @Setter @OneToMany(mappedBy = "tutor")
    private Set<Dependente> dependentes = new LinkedHashSet<>();

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_filial") @MapsId("filialId")
    private Filial filial;

    public Funcionario (String nome, String cpf, String email, String telefone , int matricula, Set<Dependente> dependentes,Filial filial){
        super(nome,cpf,email,telefone);
        this.matricula = matricula;
        this.dependentes.addAll(dependentes);
        this.filial = filial;
        key.setCpf(super.getCpf());
        key.setFilialId(filial.getId());
    }
}
