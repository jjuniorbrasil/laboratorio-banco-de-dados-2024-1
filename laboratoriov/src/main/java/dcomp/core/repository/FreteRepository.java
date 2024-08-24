package dcomp.core.repository;

import dcomp.core.entity.Frete;
import jakarta.persistence.EntityManager;

// TODO: Finalizar
public class FreteRepository {
    private final EntityManager em;
    private DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new DAOGenerico<>(em);
    }

    public Frete salvarOuAtualizar(Frete fr) {
        return daoGenerico.salvarOuAlterar(fr);
    }
}
