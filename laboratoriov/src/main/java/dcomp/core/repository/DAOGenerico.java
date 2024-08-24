package dcomp.core.repository;

import dcomp.core.entity.Cliente;
import dcomp.core.entity.EntidadeBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

public class DAOGenerico<Generic extends EntidadeBase<?>> {
    private final EntityManager em;

    public DAOGenerico(EntityManager em) {
        this.em = em;
    }

    public <Generic, ID> Generic buscaPorId(Class<Generic> classe, ID chave) {
        return em.find(classe, chave);
    }

    public Generic salvarOuAlterar(Generic entidade) {
        if(Objects.isNull(entidade.getKey()))
            this.em.persist(entidade);
        else
            entidade = this.em.merge(entidade);
        return entidade;
    }

    public void remover(Generic entidade) {
        this.em.remove(entidade);
        this.em.flush();
    }

    public List<Generic> buscarTodos(Class<Generic> c) {
        String jpql = "SELECT g FROM " + c.getSimpleName() + " g";
        TypedQuery<Generic> query = em.createQuery(jpql, c);
        return query.getResultList();
    }
}
