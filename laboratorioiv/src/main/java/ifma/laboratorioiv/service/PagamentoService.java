package ifma.laboratorioiv.service;

import ifma.laboratorioiv.core.entity.Aluguel;
import ifma.laboratorioiv.core.entity.Locacao;
import ifma.laboratorioiv.repository.AluguelRepository;
import ifma.laboratorioiv.repository.LocacaoRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PagamentoService {

    private final AluguelRepository aluguelRepository;
    private final LocacaoRepository locacaoRepository;

    public PagamentoService(AluguelRepository aluguelRepository, LocacaoRepository locacaoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.locacaoRepository = locacaoRepository;
    }

    public void registrarPagamento(Integer locacaoId, BigDecimal valorPago, Date dataPagamento, Date dataVencimento) {
        Locacao locacao = locacaoRepository.buscaPorId(locacaoId);
        if (locacao == null) {
            throw new IllegalArgumentException("Locação não encontrada.");
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setLocacao(locacao);
        aluguel.setDataVencimento(dataVencimento);  // Definindo a data de vencimento com base na data de fim da locação
        aluguel.setValorPago(valorPago);
        aluguel.setDataPagamento(dataPagamento);
        aluguel.setObservacao("Pagamento registrado.");
        aluguelRepository.salvarOuAlterar(aluguel);
    }

    public BigDecimal calcularValorComMulta(Aluguel aluguel) {
        if (!aluguel.getDataPagamento().after(aluguel.getDataVencimento())) {
            return aluguel.getLocacao().getValorAluguel();
        }

        long diffInMillies = Math.abs(aluguel.getDataPagamento().getTime() - aluguel.getDataVencimento().getTime());
        long diasAtraso = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        BigDecimal percentualMultaDiaria = new BigDecimal("0.0033");
        BigDecimal multaMaxima = aluguel.getLocacao().getValorAluguel().multiply(new BigDecimal("0.20"));
        BigDecimal multaCalculada = aluguel.getLocacao().getValorAluguel().multiply(percentualMultaDiaria).multiply(new BigDecimal(diasAtraso));

        if (multaCalculada.compareTo(multaMaxima) > 0) {
            multaCalculada = multaMaxima;
        }
        System.out.println("Aluguel pago com atraso, multa no valor de: "+ (multaCalculada).setScale(3, RoundingMode.HALF_UP).doubleValue() + ", valor total do aluguel " + (multaCalculada.doubleValue() + aluguel.getLocacao().getValorAluguel().doubleValue()));
        return aluguel.getLocacao().getValorAluguel().add(multaCalculada);
    }
}
