package dcomp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "cliente")
@SuperBuilder
public class Cliente extends PessoaFisica {
    @Column(nullable = false) @Getter @Setter
    private String contato;

    @Getter @Setter
    private boolean ativo;
}
