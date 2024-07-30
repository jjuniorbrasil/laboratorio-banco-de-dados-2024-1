package service;


import ifma.laboratorioiv.repository.AluguelRepository;

import ifma.laboratorioiv.repository.LocacaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ifma.laboratorioiv.service.PagamentoService;

import java.math.BigDecimal;
import java.util.Date;


public class TestePagamentoService {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager manager = factory.createEntityManager();
        LocacaoRepository locacaoRepo = new LocacaoRepository(manager);
        AluguelRepository aluguelRepo = new AluguelRepository(manager);

        PagamentoService pagamento = new PagamentoService(aluguelRepo, locacaoRepo);

        manager.getTransaction().begin();
        pagamento.registrarPagamento(1, new BigDecimal(150), new Date(124, 2, 3), new Date(124, 1, 15));
        manager.getTransaction().commit();

        pagamento.calcularValorComMulta(aluguelRepo.Buscarid(2));

        manager.close();
        factory.close();
    }



}



