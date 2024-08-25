package dcomp.core.repository;

import dcomp.core.entity.Frete;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FreteRepository {
    private final EntityManager em;
    private DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public Frete salvarOuAtualizar(Frete fr) {
        return daoGenerico.salvarOuAlterar(fr);
    }

    // BUSCA POR ID
    public Frete buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Frete.class, id);
    }

    // BUSCA POR nro. NOTA
    public Frete buscaPorNum(Integer num) {
        String jpql = "SELECT f FROM Frete f where f.numeroNotaFiscal = :num";
        TypedQuery<Frete> query = em.createQuery(jpql, Frete.class)
                .setParameter("num", num);
        return query.getSingleResult();
    }

    // BUSCA TODOS
    public List<Frete> buscarTodos() {
        return daoGenerico.buscarTodos(Frete.class);
    }

    // BUSCA POR CLIENTE
    public List<Frete> buscarPorCliente(String cpf) {
        String jpql = "SELECT f FROM Frete f where f.cliente.cpf = :cpf";
        TypedQuery<Frete> query = em.createQuery(jpql, Frete.class)
                .setParameter("cpf", cpf);
        return query.getResultList();
    }

    // REMOVER
    public void remover(Frete c) {
        daoGenerico.remover(c);
    }
}
