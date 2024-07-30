package ifma.laboratorioiv.repository;

import ifma.laboratorioiv.core.entity.Aluguel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AluguelRepository {
    private final EntityManager em;
    private GenericDAO<Aluguel> daoGenerico;

    public AluguelRepository(EntityManager em) {
        this.em = em;
        daoGenerico = new GenericDAO<>(em);
    }

    // Lista de aluguéis a partir do nome de um cliente (inquilino)
    public List<Aluguel> listagem(String nome) {
        String jpql = "SELECT a FROM Aluguel a where a.locacao.inquilino.nome = :nome";
        TypedQuery<Aluguel> query = em.createQuery(jpql, Aluguel.class).setParameter("nome", nome);
        return query.getResultList();
    }
    public Aluguel salvarOuAlterar(Aluguel aluguel) {
        return daoGenerico.salvarOuAlterar(aluguel);
    }
    public Aluguel Buscarid(Integer id) {
        return daoGenerico.buscaPorId(Aluguel.class, id);
    }

    // NOTE: Método movido para 'ImovelRepository':
        /* Dado um limite de preço, recuperar todos os imóveis que estão
           disponíveis, com valor do aluguel (valor_aluguel_sugerido)
           igual ou inferior ao valor informado. */

    // Recuperar uma lista com todos os aluguéis que foram pagos com atraso.
    public List<Aluguel> listagemComAtraso() {
        String jpql = "SELECT a FROM Aluguel a where a.dataPagamento > a.dataVencimento";
        return em.createQuery(jpql, Aluguel.class).getResultList();
    }
}
