package ifma.laboratorioiv.repository;
import ifma.laboratorioiv.core.entity.Profissional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

public class ProfissionalRepository {
    private final EntityManager em;
    private Profissional p = new Profissional();

    public ProfissionalRepository(EntityManager em) {
        this.em = em;
    }

    // CREATE e UPDATE
    public Profissional insereOuAtualiza(Profissional p) {
        if (Objects.isNull(p.getId())) {
            em.persist(p);   // Persiste a instância e ela torna-se gerenciada;
            return p;
        }
        p = em.merge(p); // Sincroniza dados da instância com os do banco;
        return p; // Retorna instância gerenciada, a partir de instância não gerenciada;
    }

    // READ (all)
    public Profissional buscaPorId(Integer id) {
        String jpql = "SELECT p FROM Profissional p WHERE p.id = :id";
        TypedQuery<Profissional> query = em.createQuery(jpql, Profissional.class)
                .setParameter("id", id);
        Profissional r = query.getSingleResult();
        return r;
    }

    public List<Profissional> listar() {
        String jpql = "SELECT p FROM Profissional p";
        TypedQuery<Profissional> query = em.createQuery(jpql, Profissional.class);
        return query.getResultList();
    }

    public int met(Integer i) {
        return i;
    }

    // DELETE
        // Não implementado.
}
