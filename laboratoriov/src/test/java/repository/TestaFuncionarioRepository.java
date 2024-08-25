package repository;

import dcomp.core.entity.Dependente;
import dcomp.core.entity.Filial;
import dcomp.core.entity.Funcionario;
import dcomp.core.repository.FuncionarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestaFuncionarioRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository(em);

        testeSalva(em, funcionarioRepository);
        testeAtualiza(em, funcionarioRepository);
        testeBuscaPorId(em, funcionarioRepository);
        testeBuscaTodos(em, funcionarioRepository);
        testeRemove(em, funcionarioRepository);

        em.close();
        factory.close();
    }

    private static void testeRemove(EntityManager em, FuncionarioRepository funcionarioRepository) {
        System.out.println("\tRemovendo 'Funcionario' (CPF: 147.258.369-07):\n\t===============");
        try {
            Funcionario c = funcionarioRepository.buscaPorCpf("147.258.369-07");

            em.getTransaction().begin();
            funcionarioRepository.remover(c);
            em.getTransaction().commit();

            System.out.println("Funcionario removido/deletado!");
        } catch (Exception e) {
            System.out.println("Falha ao deletar: ");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeBuscaTodos(EntityManager em, FuncionarioRepository funcionarioRepository) {
        System.out.println("\tListando funcionarios:\n\t===============");
        try {
            funcionarioRepository.buscarTodos().forEach(c -> System.out.println("Nome: " + c.getNome() + "\t- ID: " + c.getKey()));
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
        System.out.println("\t===============\n");
    }

    private static void testeAtualiza(EntityManager em, FuncionarioRepository funcionarioRepository) {
        System.out.println("\tAtualizando 'Funcionario' (CPF: 741.852.963-10):\n\t===============");
        try {;
            Funcionario f = funcionarioRepository.buscaPorCpf("741.852.963-10");
            f.setEmail("emailAlterado@email.com");

            em.getTransaction().begin();
            funcionarioRepository.salvarOuAtualizar(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Falha ao atualizar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeSalva(EntityManager em, FuncionarioRepository funcionarioRepository) {
        System.out.println("\tSalvando funcionarios:\n\t===============");
        try {
            Funcionario f = Funcionario.builder()
                    .nome("Yosuke")
                    .cpf("100.000.000-99")
                    .filial(em.find(Filial.class, 1))
                    .matricula(20230001)
                    .email("yosuke@email.com")
                    .telefone("(11) 98888-9999")
                    .build();

            em.getTransaction().begin();
            funcionarioRepository.salvarOuAtualizar(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    public static void testeBuscaPorId(EntityManager em, FuncionarioRepository funcionarioRepository) {
        System.out.println("\tBusca por ID:\n\t===============");
        try {
            Funcionario c = funcionarioRepository.buscaPorCpf("258.369.147-08");
            System.out.println("Busca por ID: " + c.getNome() + " (" + c.getCpf() + ")");
        } catch (Exception e) {
            System.out.println("Falha na busca por ID.");
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Busca por ID finalizada.\n\t===============\n");
        }
    }
}
