package dcomp.core.repository;

import dcomp.core.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class VeiculoRepository {
    private final EntityManager em;
    private DAOGenerico<Veiculo> daoGenerico;

    public VeiculoRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    // SALVA / ATUALIZA
    public Veiculo salvarOuAtualizar(Veiculo veic) {
        return daoGenerico.salvarOuAlterar(veic);
    }

    // BUSCA POR ID
    public Veiculo buscaPorPlaca(String placa) {
        String jpql = "SELECT v from Veiculo v where v.key.numeroPlaca = :placa";
        TypedQuery<Veiculo> query = em.createQuery(jpql, Veiculo.class)
                .setParameter("placa", placa);
        return query.getSingleResult();
    }

    // BUSCA TODOS
    public List<Veiculo> buscarTodos() {
        return daoGenerico.buscarTodos(Veiculo.class);
    }

    // REMOVER
    public void remover(Veiculo c) {
        daoGenerico.remover(c);
    }
}