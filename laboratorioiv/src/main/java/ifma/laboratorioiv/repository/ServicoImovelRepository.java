package ifma.laboratorioiv.repository;

import ifma.laboratorioiv.core.entity.ServicoImovel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ServicoImovelRepository {
    private final EntityManager em;
    private GenericDAO<ServicoImovel> daoGenerico;

    public ServicoImovelRepository(EntityManager em) {
        this.em = em;
        this.daoGenerico = new GenericDAO<>(em);
    }

    // Inserir/Atualizar
    public ServicoImovel insereOuAtualiza(ServicoImovel servico) {
        return daoGenerico.salvarOuAlterar(servico);
    }

    // Listar por imóvel (id)
    public List<ServicoImovel> listagem(Integer id) {
        String jpql = "SELECT servico from ServicoImovel servico where servico.imovel.id = :id";
        TypedQuery<ServicoImovel> query = em.createQuery(jpql, ServicoImovel.class)
                .setParameter("id", id);
        return query.getResultList();
    }
}
