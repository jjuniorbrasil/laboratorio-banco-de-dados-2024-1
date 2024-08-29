package service;

import dcomp.core.repository.*;
import dcomp.core.entity.Frete;
import dcomp.core.service.CadastroFrete;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class testeCadastroFrete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager manager = factory.createEntityManager();
        CidadeRepository cidrepo = new CidadeRepository(manager);
        FreteRepository freterepo = new FreteRepository(manager);
        ClienteRepository clienterepo = new ClienteRepository(manager);
        VeiculoRepository veiculorepo = new VeiculoRepository(manager);
        CategoriaFreteRepository cadastroFreterepo = new CategoriaFreteRepository(manager);

        CadastroFrete cadastrofrete = new CadastroFrete(freterepo, cidrepo, manager);

        cadastrofrete.registrarFrete(
                clienterepo.buscaPorCpf("123.456.789-01"),
                cadastroFreterepo.buscaPorId(2),
                veiculorepo.buscaPorPlaca("ESG-9999"),
                cidrepo.buscaPorId(1),
                cidrepo.buscaPorId(2),
                1001,
                new BigDecimal(1),
                20
        );

        // Exibe a categoria do frete registrado
        System.out.print("\n\nFrete da categoria " + freterepo.buscaPorNum(1001).getCategoria().getNome() + "\n\n");

        // Calcula e exibe o valor do frete
      System.out.print( "Valor do frete em: "+ cadastrofrete.calcularValorFrete(freterepo.buscaPorNum(1001)) +"\n\n");

        // Teste para listar todos os fretes de um cliente
        String cpfCliente = "123.456.789-01";
        List<Frete> fretesCliente = cadastrofrete.buscarFretesPorCliente(cpfCliente);

        System.out.println("Lista de fretes do cliente com CPF: " + cpfCliente);
        for (Frete frete : fretesCliente) {
            System.out.println("Frete ID: " + frete.getNumeroNotaFiscal() + ", Valor: " + cadastrofrete.calcularValorFrete(frete));
        }

        // Fecha o EntityManager e o EntityManagerFactory
        manager.close();
        factory.close();
    }
}