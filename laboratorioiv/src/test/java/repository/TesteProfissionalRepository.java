package repository;

import ifma.laboratorioiv.core.entity.Profissao;
import ifma.laboratorioiv.core.entity.Profissional;
import ifma.laboratorioiv.repository.ProfissionalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class TesteProfissionalRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager em = factory.createEntityManager();

        // REPOSITORY
        ProfissionalRepository rep = new ProfissionalRepository(em);

        // OPERAÇÕES
        buscaPorId(rep);
        insercaoProfissional(rep, em);
        updateProfissional(rep, em);
        listagemProfissional(rep);

        em.close();
        factory.close();
    }

    private static void listagemProfissional(ProfissionalRepository rep) {
        // LIST-ALL
        rep.listar().forEach(u -> System.out.println(u.getNome() + " (" + u.getId() + ")"));
    }

    private static void insercaoProfissional(ProfissionalRepository rep, EntityManager em) {
        // INSERÇÃO
        em.getTransaction().begin();
        Profissional p2 = new Profissional(null, "Frieren", "121242423", "15124124", "Novo cliente", new Profissao("Maga", new BigDecimal(132.2)));
        rep.insereOuAtualiza(p2);
        em.getTransaction().commit();
    }

    private static void updateProfissional(ProfissionalRepository rep, EntityManager em) {
        em.getTransaction().begin();
        Profissional p = rep.buscaPorId(5);
        p.setObservacao("Novo cliente");
        rep.insereOuAtualiza(p);
        em.getTransaction().commit();
    }

    static void buscaPorId(ProfissionalRepository rep) {
        // Busca por ID
        Profissional p = rep.buscaPorId(1);
        System.out.println("Profissional encontrado: " + p.getId() + ": " + p.getNome() + "\n");
    }
}
