package repository;

import ifma.laboratorioiv.core.entity.Aluguel;
import ifma.laboratorioiv.repository.AluguelRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TesteAluguelRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager em = factory.createEntityManager();
        AluguelRepository rep = new AluguelRepository(em);

        // OPERAÇÕES
        listar(rep, "Stark"); // Por ID de imóvel.
        listarComAtraso(rep);

        em.close();
        factory.close();
    }

    private static void listarComAtraso(AluguelRepository rep) {
        System.out.println("Buscando aluguéis com atraso: ");
        List<Aluguel> lista = rep.listagemComAtraso();
        lista.forEach(a -> System.out.println("Observação: " + a.getObservacao() + " - Imóvel: " +  a.getLocacao().getImovel().getId()));
        System.out.println("Busca finalizada!\n");
    }

    private static void listar(AluguelRepository rep, String cliente) {
        System.out.println("Buscando aluguéis do usuário " + cliente);
        List<Aluguel> lista = rep.listagem(cliente);
        try {
        lista.forEach(aluguel -> System.out.println("VENCE EM: " + aluguel.getDataVencimento() +
                " - Imóvel: " + aluguel.getLocacao().getImovel().getId()));
        } catch (RuntimeException err) {
            System.out.println(err.toString());
        } finally {
            System.out.println("Listagem finalizada!\n");
        }
    }
}
