package repository;

import dcomp.core.entity.CategoriaFrete;
import dcomp.core.entity.Cliente;
import dcomp.core.repository.CategoriaFreteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestaCategoriaFreteRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        CategoriaFreteRepository categoriaFreteRepository = new CategoriaFreteRepository(em);

        testeSalva(em, categoriaFreteRepository);
        testeAtualiza(em, categoriaFreteRepository);
        testeBuscaPorId(em, categoriaFreteRepository);
        testeBuscaTodos(em, categoriaFreteRepository);
        testeRemove(em, categoriaFreteRepository);

        em.close();
        factory.close();
    }

    private static void testeRemove(EntityManager em, CategoriaFreteRepository categoriaFreteRepository) {
        System.out.println("\tRemovendo 'categoriaFrete' (4) :\n\t===============");
        try {
            CategoriaFrete cat = categoriaFreteRepository.buscaPorId(4);

            em.getTransaction().begin();
            categoriaFreteRepository.remover(cat);
            em.getTransaction().commit();

            System.out.println("Categoria removida/deletada!");
        } catch (Exception e) {
            System.out.println("Falha ao deletar: ");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeBuscaTodos(EntityManager em, CategoriaFreteRepository categoriaFreteRepository) {
        System.out.println("\tListando 'categoriaFrete's:\n\t===============");
        try {
            categoriaFreteRepository.buscarTodos().forEach(c -> System.out.println("CategoriaFrete: " + c.getNome() + " (" + c.getDescricao() + ")"));
            System.out.println("\t===============");
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
    }

    private static void testeAtualiza(EntityManager em, CategoriaFreteRepository categoriaFreteRepository) {
        System.out.println("\tAtualizando 'categoriaFrete':\n\t===============");
        try {
            CategoriaFrete cat = categoriaFreteRepository.buscaPorId(2);
            cat.setDescricao("Descrição alterada!");
            em.getTransaction().begin();
            categoriaFreteRepository.salvarOuAtualizar(cat);
            em.getTransaction().commit();
            System.out.println("CategoriaFrete salva!");
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeSalva(EntityManager em, CategoriaFreteRepository categoriaFreteRepository) {
        System.out.println("\tSalvando categoriaFretes:\n\t===============");
        try {
            CategoriaFrete cat = CategoriaFrete.builder()
                    .nome("Categoria Teste")
                    .descricao("Categoria para persistência.")
                    .percentualAdicional(2.0f)
                    .build();
            em.getTransaction().begin();
            categoriaFreteRepository.salvarOuAtualizar(cat);
            em.getTransaction().commit();
            System.out.println("CategoriaFrete salva!");
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    public static void testeBuscaPorId(EntityManager em, CategoriaFreteRepository categoriaFreteRepository) {
        System.out.println("\tBusca por ID:\n\t===============");
        try {
            CategoriaFrete c = categoriaFreteRepository.buscaPorId(3);
            System.out.println("Busca por ID: " + c.getNome() + " (" + c.getId() + ")");
        } catch (Exception e) {
            System.out.println("Falha na busca por ID.");
        } finally {
            System.out.println("Busca por ID finalizada.\n\t===============\n");
        }
    }
}
