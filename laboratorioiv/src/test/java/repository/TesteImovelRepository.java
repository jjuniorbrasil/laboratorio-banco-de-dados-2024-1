package repository;

import ifma.laboratorioiv.core.entity.Cliente;
import ifma.laboratorioiv.core.entity.Endereco;
import ifma.laboratorioiv.core.entity.Imovel;
import ifma.laboratorioiv.core.entity.enums.TipoImovel;
import ifma.laboratorioiv.repository.ClienteRepository;
import ifma.laboratorioiv.repository.ImovelRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class TesteImovelRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager em = factory.createEntityManager();

        // REPOSITORY
        ImovelRepository rep = new ImovelRepository(em);

        // OPERAÇÕES
        inserir(rep, em);
        inserirNovamente(rep, em);
        atualizar(rep, em);
        buscar(rep);
        listar(rep);
        listarComValorMaximo(rep, new BigDecimal("1000.0"));

        em.close();
        factory.close();
    }

    private static void listarComValorMaximo(ImovelRepository rep, BigDecimal bigDecimal) {
        List<Imovel> lista = rep.listagem(new BigDecimal("1000.0"));
        for (Imovel imovel : lista) {
            System.out.println(imovel.getProprietario().getNome());
        }
    }

    private static void atualizar(ImovelRepository rep, EntityManager em) {
        em.getTransaction().begin();
        Imovel i = rep.buscaPorId(1);
        i.setObservacao("Observação inserida...");
        em.getTransaction().commit();
    }

    private static void inserir(ImovelRepository rep, EntityManager em) {
        em.getTransaction().begin();

        Cliente proprietario = Cliente.builder()
                .nome("Frieren")
                .CPF("1")
                .telefone("9")
                .build();
        em.persist(proprietario);

        Imovel i = Imovel.builder()
                .tipo(TipoImovel.TIPO1)
                .proprietario(proprietario)
                .observacao("Imóvel da Frieren")
                .endereco(new Endereco("12329-233", "Midland", "B"))
                .build();
        rep.insereOuAtualiza(i);


        em.getTransaction().commit();
    }

    private static void inserirNovamente(ImovelRepository rep, EntityManager em) {
        em.getTransaction().begin();

        Cliente proprietario2 = Cliente.builder()
                .nome("Fern")
                .CPF("2")
                .telefone("9")
                .build();
        em.persist(proprietario2);

        Imovel i2 = Imovel.builder()
                .tipo(TipoImovel.TIPO1)
                .proprietario(proprietario2)
                .observacao("Imóvel da Fern")
                .endereco(new Endereco("12329-233", "Midland", "A"))
                .build();
        rep.insereOuAtualiza(i2);

        em.getTransaction().commit();
    }

    private static void buscar(ImovelRepository rep) {
        Imovel i = rep.buscaPorId(1);
        System.out.println("Imóvel: " + i.getId());
    }

    private static void listar(ImovelRepository rep) {
        List<Imovel> lista = rep.listagem();
        lista.forEach(i -> System.out.println(i.getId() + ": " + i.getEndereco().getCEP() + " - OBS: " + i.getObservacao()));
    }
}
