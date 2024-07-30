package repository;

import ifma.laboratorioiv.core.entity.Cliente;
import ifma.laboratorioiv.core.entity.Endereco;
import ifma.laboratorioiv.core.entity.Imovel;
import ifma.laboratorioiv.repository.AluguelRepository;
import ifma.laboratorioiv.core.entity.Locacao;
import ifma.laboratorioiv.core.entity.enums.TipoImovel;
import ifma.laboratorioiv.repository.ClienteRepository;
import ifma.laboratorioiv.repository.ImovelRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ifma.laboratorioiv.repository.LocacaoRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TesteLocacaoRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager manager = factory.createEntityManager();
        LocacaoRepository locacaoRepo = new LocacaoRepository(manager);
        ClienteRepository clienteRepo = new ClienteRepository(manager);
        ImovelRepository imovelRepo = new ImovelRepository(manager);

        atualizar(locacaoRepo, manager);
        inserir(locacaoRepo, clienteRepo, imovelRepo, manager);
        inserirNovamente(locacaoRepo,clienteRepo, imovelRepo,manager);
        //buscarPorCliente(locacaoRepo);
        listar(locacaoRepo);

        manager.close();
        factory.close();
    }

    private static void inserir(LocacaoRepository locacaoRepo, ClienteRepository clienteRepo, ImovelRepository imovelRepo, EntityManager em) {
        em.getTransaction().begin();
        Cliente inquilino = Cliente.builder()
                .nome("Guts")
                .CPF("12345678901")
                .telefone("987654321")
                .build();
        clienteRepo.salvarOuAlterar(inquilino);
        Locacao l = Locacao.builder()
                .imovel(imovelRepo.buscaPorId(1))
                .ativo(true)
                .valorAluguel(new BigDecimal(200))
                .dataInicio(new Date(2024-1900, 2, 4))
                .dataFim(new Date(2024-1900, 3, 4))
                .diaVencimento((short) 8)
                .observacao("locacao inserida")
                .inquilino(inquilino)
                .build();

        locacaoRepo.salvarOuAlterar(l);
        em.getTransaction().commit();

    }
    private static void inserirNovamente(LocacaoRepository locacaoRepo, ClienteRepository clienteRepo, ImovelRepository imovelRepo, EntityManager em) {
        em.getTransaction().begin();
        Cliente inquilino = Cliente.builder()
                .nome("Dutch")
                .CPF("72375678501")
                .telefone("927654321")
                .build();
        clienteRepo.salvarOuAlterar(inquilino);
        Locacao l = Locacao.builder()
                .imovel(imovelRepo.buscaPorId(2))
                .ativo(true)
                .valorAluguel(new BigDecimal(200))
                .dataInicio(new Date(2024-1900, 2, 4))
                .dataFim(new Date(2024-1900, 3, 4))
                .diaVencimento((short) 8)
                .observacao("locacao inserida")
                .inquilino(inquilino)
                .build();
        locacaoRepo.salvarOuAlterar(l);
        em.getTransaction().commit();

    }

    private static void atualizar(LocacaoRepository locacaoRepo, EntityManager em) {
        em.getTransaction().begin();
        Locacao locacao = locacaoRepo.buscaPorId(1);
        System.out.println(locacao + " aviso aviso aviso aviso");
        locacao.setAtivo(false); //mude isso para testar se o sitema está testando se o imovel está ou não disponível
        locacao.setObservacao("OBS: a locacao atualizou o status de ativo");
        em.getTransaction().commit();
    }

    private static void listar(LocacaoRepository locacaoRepo) {
        List<Locacao> lista = locacaoRepo.listarTodas();
        lista.forEach(i -> System.out.println("Locacao n°: " + i.getId() + ": ImovelID:"+i.getImovel().getId()+ ": está ativo? " + i.isAtivo() + ": inquilino: " + i.getInquilino().getNome() + ": proprietário: " + i.getImovel().getProprietario().getNome() + ": datafim:" +i.getDataFim()+" " + i.getObservacao()));
    }
}