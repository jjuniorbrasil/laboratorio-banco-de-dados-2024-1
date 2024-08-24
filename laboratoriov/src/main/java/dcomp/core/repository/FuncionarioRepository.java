package dcomp.core.repository;

import dcomp.core.entity.Funcionario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FuncionarioRepository {
    private final EntityManager em;
    private DAOGenerico<Funcionario> daoGenerico;

    public FuncionarioRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public Funcionario salvarOuAtualizar(Funcionario cli) {
        return daoGenerico.salvarOuAlterar(cli);
    }

    // BUSCA POR ID
    public Funcionario buscaPorCpf(String cpf) {
        return daoGenerico.buscaPorId(Funcionario.class, cpf);
    }

    // BUSCA TODOS
    public List<Funcionario> buscarTodos() {
        return daoGenerico.buscarTodos(Funcionario.class);
    }

    // REMOVER
    public void remover(Funcionario c) {
        daoGenerico.remover(c);
    }
}