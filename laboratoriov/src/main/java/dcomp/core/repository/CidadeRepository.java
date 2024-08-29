package dcomp.core.repository;

import dcomp.core.entity.Cidade;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CidadeRepository {
    private final EntityManager em;
    private DAOGenerico<Cidade> daoGenerico;

    public CidadeRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public Cidade salvarOuAtualizar(Cidade cid) {
        return daoGenerico.salvarOuAlterar(cid);
    }

    // BUSCA POR ID
    public Cidade buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    // BUSCA TODOS
    public List<Cidade> buscarTodos() {
        return daoGenerico.buscarTodos(Cidade.class);
    }

    // REMOVER
    // Não implementado

}
