package dcomp.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class PessoaFisica {
    private String nome;

    @Getter
    private String cpf;
    private String email;
    private String telefone;
}
