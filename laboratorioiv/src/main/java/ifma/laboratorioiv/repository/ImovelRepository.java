package ifma.laboratorioiv.repository;

import ifma.laboratorioiv.core.entity.Imovel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


public class ImovelRepository {
    private final EntityManager em;

    // TODO: Implementar DAO
    public ImovelRepository(EntityManager em) {
        this.em = em;
    }

    public List<Imovel> listagem() {
        String jpql = "select i from Imovel i";
        TypedQuery<Imovel> query = em.createQuery(jpql, Imovel.class);
        List<Imovel> lista = query.getResultList();
        return lista;
    }

    // Lista apenas imóveis que condizem com o valor máximo para aluguel informado
    public List<Imovel> listagem(BigDecimal valorMax) {
        String jpql = "select i from Imovel i where i.valorAluguelSugerido <= :valor";
        TypedQuery<Imovel> query = em.createQuery(jpql, Imovel.class)
                .setParameter("valor", valorMax);
        List<Imovel> lista = query.getResultList();
        return lista;
    }

    public Imovel buscaPorId(Integer id) {
        return (Imovel) em.createQuery("SELECT i FROM Imovel i where i.id = :id")
                        .setParameter("id", id)
                        .getSingleResult();
    }

    // TODO: verificar se CPF é único
    public Imovel insereOuAtualiza(Imovel i) {
        if (Objects.isNull(i.getId())) {
            em.persist(i);
            return i;
        }
        i = em.merge(i);
        return i;
    }

}
