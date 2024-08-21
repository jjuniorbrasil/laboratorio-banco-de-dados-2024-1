package dcomp.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
public class Funcionario extends PessoaFisica {

    @Getter
    private FuncionarioPK key;

    @Getter @Setter
    private Set<Dependente> dependentes = new LinkedHashSet<>();

    @Getter @Setter
    private Filial filial;

    public Funcionario (String nome, String cpf, String email, String telefone , FuncionarioPK key , Set<Dependente> dependentes){
        super(nome,cpf,email,telefone);
        this.key = key;
        this.dependentes.addAll(dependentes);
        key.setCpf(super.getCpf());
    }
}
