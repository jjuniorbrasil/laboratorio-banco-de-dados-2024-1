package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Dependente {

    @EmbeddedId @Getter
    private DependentePK key = new DependentePK();

    @Getter @Column(nullable = false)
    private String nome;

    @Getter @Column(nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne @Getter @Setter @MapsId("cpftutor")
    private Funcionario tutor;

    public Dependente( String nome, LocalDate dataNascimento, Funcionario tutor ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tutor = tutor;
        key.setCpfTutor(tutor.getKey().getCpf());
    }
}
