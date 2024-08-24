package repository;

import dcomp.core.entity.*;
import dcomp.core.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TestaClienteRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        ClienteRepository clienteRepository = new ClienteRepository(em);

        testeSalva(em, clienteRepository);
        testeAtualiza(em, clienteRepository);
        testeBuscaPorId(em, clienteRepository);
        testeBuscaTodos(em, clienteRepository);
        testeRemove(em, clienteRepository);

        em.close();
        factory.close();
    }

    private static void testeRemove(EntityManager em, ClienteRepository clienteRepository) {
        System.out.println("\tRemovendo 'Cliente' (CPF: 100.093.239-23) :\n\t===============");
        try {
            Cliente c = clienteRepository.buscaPorCpf("100.093.239-23");

            em.getTransaction().begin();
            clienteRepository.remover(c);
            em.getTransaction().commit();

            System.out.println("Cliente removido/deletado!");
        } catch (Exception e) {
            System.out.println("Falha ao deletar: ");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeBuscaTodos(EntityManager em, ClienteRepository clienteRepository) {
        System.out.println("\tListando clientes:\n\t===============");
        try {
            clienteRepository.buscarTodos().forEach(c -> System.out.println("Cliente: " + c.getNome() + " - ATIVO: " + (c.isAtivo() ? "Sim" : "Não")));
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
    }

    private static void testeAtualiza(EntityManager em, ClienteRepository clienteRepository) {
        System.out.println("\tAtualizando 'Cliente' (CPF: 789.123.456-05):\n\t===============");
        try {
            Cliente c = clienteRepository.buscaPorCpf("789.123.456-05");

            c.setEmail("almeida.carlos@email.com");
            c.setContato(c.getEmail());
            if (!c.isAtivo()) c.setAtivo(true);
            else System.out.println("Cliente já está ativo!");

            em.getTransaction().begin();
            clienteRepository.salvarOuAtualizar(c);
            em.getTransaction().commit();

            System.out.println("Cliente atualizado!");
        } catch (Exception e) {
            System.err.println("Falha ao atualizar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeSalva(EntityManager em, ClienteRepository clienteRepository) {
        System.out.println("\tSalvando clientes:\n\t===============");
        try {
            Cliente c = Cliente.builder()
                    .nome("José Júnior")
                    .cpf("100.093.239-23")
                    .email("jose.junior@email.com")
                    .telefone("2342-3452")
                    .contato("jose.junior@email.com")
                    .ativo(true)
                    .build();

            Cliente c2 = Cliente.builder()
                    .nome("João Carlos")
                    .cpf("100.003.239-23")
                    .email("joao.carlos@email.com")
                    .telefone("2342-3452")
                    .contato("joao.carlos@email.com")
                    .ativo(true)
                    .build();

            em.getTransaction().begin();
            clienteRepository.salvarOuAtualizar(c);
            clienteRepository.salvarOuAtualizar(c2);
            em.getTransaction().commit();

            System.out.println("Clientes salvos!");
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    public static void testeBuscaPorId(EntityManager em, ClienteRepository clienteRepository) {
        System.out.println("\tBusca por ID:\n\t===============");
        try {
            Cliente c = clienteRepository.buscaPorCpf("123.456.789-01");
            System.out.println("Busca por ID: " + c.getNome() + " (" + c.getCpf() + ")");
        } catch (Exception e) {
            System.out.println("Falha na busca por ID.");
        } finally {
            System.out.println("Busca por ID finalizada.\n\t===============\n");
        }
    }
}
