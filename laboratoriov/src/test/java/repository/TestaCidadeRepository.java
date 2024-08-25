package repository;

import dcomp.core.entity.Cidade;
import dcomp.core.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestaCidadeRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        CidadeRepository cidadeRepository = new CidadeRepository(em);

        testeSalva(em, cidadeRepository);
        //testeAtualiza(em, cidadeRepository);
        testeBuscaPorId(em, cidadeRepository);
        testeBuscaTodos(em, cidadeRepository);
        //testeRemove(em, cidadeRepository);

        em.close();
        factory.close();
    }

    private static void testeRemove(EntityManager em, CidadeRepository cidadeRepository) {
        // NOTA: Não implementado. Operação perigosa para fretes e distâncias.
    }

    private static void testeBuscaTodos(EntityManager em, CidadeRepository cidadeRepository) {
        System.out.println("\tListando cidades:\n\t===============");
        try {
            cidadeRepository.buscarTodos().forEach(c -> System.out.println("Cidade: " + c.getNome() + " (" + c.getUf() + ")"));
            System.out.println("\t===============");
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
    }

    private static void testeAtualiza(EntityManager em, CidadeRepository cidadeRepository) {
            // NOTA: Não implementado. Entidade não possui setters significantes.
    }

    private static void testeSalva(EntityManager em, CidadeRepository cidadeRepository) {
        System.out.println("\tSalvando cidades:\n\t===============");
        try {
            Cidade c = Cidade.builder()
                    .uf("MA")
                    .estado("Maranhão")
                    .nome("São Luís")
                    .build();
            em.getTransaction().begin();
            cidadeRepository.salvarOuAtualizar(c);
            em.getTransaction().commit();
            System.out.println("Cidade salva!");
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    public static void testeBuscaPorId(EntityManager em, CidadeRepository cidadeRepository) {
        System.out.println("\tBusca por ID:\n\t===============");
        try {
            Cidade c = cidadeRepository.buscaPorId(3);
            System.out.println("Busca por ID: " + c.getNome() + " (" + c.getId() + ")");
        } catch (Exception e) {
            System.out.println("Falha na busca por ID.");
        } finally {
            System.out.println("Busca por ID finalizada.\n\t===============\n");
        }
    }
}
