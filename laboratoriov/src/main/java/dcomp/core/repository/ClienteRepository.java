package dcomp.core.repository;

import dcomp.core.entity.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteRepository {
    private final EntityManager em;
    private DAOGenerico<Cliente> daoGenerico;

    public ClienteRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public Cliente salvarOuAtualizar(Cliente cli) {
        return daoGenerico.salvarOuAlterar(cli);
    }

    // BUSCA POR ID
    public Cliente buscaPorCpf(String cpf) {
        return daoGenerico.buscaPorId(Cliente.class, cpf);
    }

    // BUSCA TODOS
    public List<Cliente> buscarTodos() {
        return daoGenerico.buscarTodos(Cliente.class);
    }

    // REMOVER
    public void remover(Cliente c) {
        daoGenerico.remover(c);
    }
}