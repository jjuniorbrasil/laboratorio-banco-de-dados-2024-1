package dcomp.core.repository;

import dcomp.core.entity.CategoriaFrete;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaFreteRepository {
    private final EntityManager em;
    private DAOGenerico<CategoriaFrete> daoGenerico;

    public CategoriaFreteRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public CategoriaFrete salvarOuAtualizar(CategoriaFrete cat) {
        return daoGenerico.salvarOuAlterar(cat);
    }

    // BUSCA POR ID
    public CategoriaFrete buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(CategoriaFrete.class, id);
    }

    // BUSCA TODOS
    public List<CategoriaFrete> buscarTodos() {
        return daoGenerico.buscarTodos(CategoriaFrete.class);
    }

    // REMOVER
    public void remover(CategoriaFrete cat) {
        daoGenerico.remover(cat);
    }
}