package dcomp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Cliente extends PessoaFisica{

    @Column(nullable = false)
    private String contato;

    private boolean ativo;
}
