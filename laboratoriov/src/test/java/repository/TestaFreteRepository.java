package repository;

import dcomp.core.entity.Frete;
import dcomp.core.entity.Veiculo;
import dcomp.core.entity.VeiculoPK;
import dcomp.core.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestaFreteRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        FreteRepository freteRepository = new FreteRepository(em);

        testeSalva(em, freteRepository);
        testeAtualiza(em, freteRepository);
        testeBusca(em, freteRepository);
        testeBuscaTodos(em, freteRepository);
        testeBuscaPorCliente(em, freteRepository);
        testeRemove(em, freteRepository);

        em.close();
        factory.close();
    }

    private static void testeBuscaPorCliente(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tListando fretes por cliente (CPF: 123.456.789-01):\n\t===============");
        try {
            freteRepository.buscarPorCliente("123.456.789-01").forEach(fr -> System.out.println("Frete: " + fr.getCidadeOrigem().getNome() + " - ATÉ: " + fr.getCidadeDestino().getNome()));
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
    }

    private static void testeRemove(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tRemovendo 'Frete' (2) :\n\t===============");
        try {
            Frete fr = freteRepository.buscaPorId(2);

            em.getTransaction().begin();
            freteRepository.remover(fr);
            em.getTransaction().commit();

            System.out.println("Frete removido/deletado!");
        } catch (Exception e) {
            System.out.println("Falha ao deletar: ");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeBuscaTodos(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tListando fretes:\n\t===============");
        try {
            freteRepository.buscarTodos().forEach(fr -> System.out.println("Frete: " + fr.getCidadeOrigem().getNome() + " - ATÉ: " + fr.getCidadeDestino().getNome()));
            System.out.println(" ");
        } catch (Exception e) {
            System.err.println("Falha na listagem: " + e.getMessage());
        }
    }

    private static void testeAtualiza(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tAtualizando 'Frete':\n\t===============");
        try {
            VeiculoRepository veiculoRepository = new VeiculoRepository(em);

            Veiculo v = veiculoRepository.buscaPorPlaca("OPQ-7890");
            Frete fr = freteRepository.buscaPorId(1);
            fr.setVeiculo(v);

            em.getTransaction().begin();
            freteRepository.salvarOuAtualizar(fr);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Falha ao atualizar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    private static void testeSalva(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tSalvando fretes:\n\t===============");
        try {
            CategoriaFreteRepository categoriaFreteRepository = new CategoriaFreteRepository(em);
            CidadeRepository cidadeRepository = new CidadeRepository(em);
            ClienteRepository clienteRepository = new ClienteRepository(em);
            VeiculoRepository veiculoRepository = new VeiculoRepository(em);

            Frete f = Frete.builder()
                    .categoria(categoriaFreteRepository.buscaPorId(1))
                    .cidadeOrigem(cidadeRepository.buscaPorId(9))
                    .cidadeDestino(cidadeRepository.buscaPorId(1))
                    .numeroNotaFiscal(5326216)
                    .valorKmRodado(new BigDecimal(2))
                    .veiculo(veiculoRepository.buscaPorPlaca("OPQ-7890"))
                    .cliente(clienteRepository.buscarTodos().get(1))
                    .build();

            em.getTransaction().begin();
            freteRepository.salvarOuAtualizar(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Falha ao salvar.");
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizado.\n\t===============\n");
    }

    public static void testeBusca(EntityManager em, FreteRepository freteRepository) {
        System.out.println("\tBusca por ID e nro. da Nota:\n\t===============");
        try {
            List<Frete> list = new ArrayList<>();
            Frete fr1 = freteRepository.buscaPorId(1);
            Frete fr2 = freteRepository.buscaPorNum(5326216);
            list.add(fr1);
            list.add(fr2);
            list.forEach(fr -> System.out.println("Busca: " + fr.getCidadeOrigem().getNome() + " (até " + fr.getCidadeDestino().getNome() + ")"));
        } catch (Exception e) {
            System.out.println("Falha na busca.");
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Busca finalizada.\n\t===============\n");
        }
    }
}
