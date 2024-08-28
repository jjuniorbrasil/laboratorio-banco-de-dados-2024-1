package dcomp.core.repository;

import dcomp.core.entity.Cidade;
import dcomp.core.entity.Distancia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
     public List<Distancia> buscarDistanciasPorCidade(Integer cidadeId) {
        String jpql = "SELECT d FROM Distancia d WHERE d.origem.id = :cidadeId OR d.destino.id = :cidadeId";
       TypedQuery<Distancia> query = em.createQuery(jpql, Distancia.class);
       query.setParameter("cidadeId", cidadeId);
       return query.getResultList();
    }
}
