package ifma.laboratorioiv.repository;

import ifma.laboratorioiv.core.entity.Locacao;
import ifma.laboratorioiv.core.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LocacaoRepository {

    private final EntityManager em;
    private GenericDAO<Locacao> daoGenerico;

    public LocacaoRepository(EntityManager em) {
        this.em = em;
        daoGenerico = new GenericDAO<>(em);
    }

    //inserir ou atualizar uma locação
    public Locacao salvarOuAlterar(Locacao locacao) {
        // Verificar a disponibilidade do imóvel
        if (!isImovelDisponivel(locacao)) {
            throw new IllegalArgumentException("Imóvel não disponível para locação.");
        }
        return daoGenerico.salvarOuAlterar(locacao);
    }

    //listar todas as locações de um determinado cliente
    public List<Locacao> listarPorCliente(Cliente cliente) {
        String jpql = "SELECT l FROM Locacao l WHERE l.inquilino = :cliente";
        TypedQuery<Locacao> query = em.createQuery(jpql, Locacao.class)
                .setParameter("cliente", cliente);
        return query.getResultList();
    }

    // Verificar se um imóvel está disponível para locação
    private boolean isImovelDisponivel(Locacao l) {
        String jpql = "SELECT COUNT(l) FROM Locacao l WHERE l.imovel = :imovel AND l.ativo = true";
        Long lotado = (em.createQuery(jpql, Long.class)
                .setParameter("imovel", l.getImovel())
                .getSingleResult());
        return lotado == 0 ;
    }

    //buscar locação por ID
    public Locacao buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Locacao.class, id);
    }

    //listar todas as locações
    public List<Locacao> listarTodas() {
        String jpql = "SELECT l FROM Locacao l";
        TypedQuery<Locacao> query = em.createQuery(jpql, Locacao.class);
        return query.getResultList();
    }
}
