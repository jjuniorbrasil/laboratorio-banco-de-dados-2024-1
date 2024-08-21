package dcomp.core.entity;

import java.time.LocalDate;

public class Dependente {

    private DependentePK key = new DependentePK();
    private String nome;
    private LocalDate dataNascimento;
    private Funcionario tutor;

    public Dependente(DependentePK key, String nome, LocalDate dataNascimento, Funcionario tutor) {
        this.key = key;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tutor = tutor;
        key.setCpfTutor(tutor.getKey().getCpf());
    }
}
