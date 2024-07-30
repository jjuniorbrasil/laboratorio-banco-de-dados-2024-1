package repository;

import ifma.laboratorioiv.core.entity.Imovel;
import ifma.laboratorioiv.core.entity.Profissional;
import ifma.laboratorioiv.core.entity.ServicoImovel;
import ifma.laboratorioiv.repository.ServicoImovelRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TesteServicoImovelRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager em = factory.createEntityManager();
        ServicoImovelRepository rep = new ServicoImovelRepository(em);

        // OPERAÇÕES
        inserir(rep, em);
        atualizar(rep, em);
        listar(rep); // Por ID de imóvel.

        em.close();
        factory.close();
    }

    private static void listar(ServicoImovelRepository rep) {
        List<ServicoImovel> lista = rep.listagem(1);
        lista.forEach(servico -> System.out.println(servico.getDataServico() + ": " + servico.getObservacao()));
    }

    private static void atualizar(ServicoImovelRepository rep, EntityManager em) {
        ServicoImovel servico = em.find(ServicoImovel.class, 1);

        em.getTransaction().begin();

        servico.setValorTotal(new BigDecimal("4000.0"));
        servico.setObservacao("Atualização de valor (" + new Date().toString() + "): R$" +
                servico.getValorTotal().toString());

        rep.insereOuAtualiza(servico);
        em.getTransaction().commit();
    }

    private static void inserir(ServicoImovelRepository rep, EntityManager em) {
        em.getTransaction().begin();
        Profissional p = em.find(Profissional.class, 1);
        Imovel i = em.find(Imovel.class, 1);

        ServicoImovel servico = ServicoImovel.builder()
                .dataServico(new Date())
                .imovel(i)
                .profissional(p)
                .build();

        rep.insereOuAtualiza(servico);
        em.getTransaction().commit();
    }
}
