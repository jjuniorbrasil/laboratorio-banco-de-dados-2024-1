package dcomp.core.service;

import dcomp.core.entity.*;
import dcomp.core.repository.CategoriaFreteRepository;
import dcomp.core.repository.CidadeRepository;
import dcomp.core.repository.ClienteRepository;
import dcomp.core.repository.FreteRepository;

import java.math.BigDecimal;
import java.util.List;

public class CadastroFrete {
    private final FreteRepository freteRepository;
    private final CidadeRepository cidadeRepository;
    private static final double VALOR_POR_KM = 5.0; // Valor padrão por km rodado

    public CadastroFrete(FreteRepository freteRepository, CidadeRepository cidadeRepository) {
        this.freteRepository = freteRepository;
        this.cidadeRepository = cidadeRepository;

    }

    // Registra um novo frete
    public void registrarFrete(Cliente cliente, CategoriaFrete categoriaFrete, Veiculo veiculo, Cidade cidadeOrigem, Cidade cidadeDestino, int numeroNotaFiscal, BigDecimal valorKmRodado, Integer codigo) {
        Frete frete = Frete.builder()
                .cliente(cliente)
                .veiculo(veiculo)
                .categoria(categoriaFrete)
                .cidadeOrigem(cidadeOrigem)
                .cidadeDestino(cidadeDestino)
                .numeroNotaFiscal(numeroNotaFiscal)
                .valorKmRodado(valorKmRodado)
                .codigo(codigo)
                .build();
        freteRepository.salvarOuAtualizar(frete);
    }

    // Calcula o valor do frete com base na distância entre as cidades e na categoria do frete
    public double calcularValorFrete(Frete frete) {
       double valor = frete.getValorKmRodado().doubleValue() * getDistancia(frete.getCidadeOrigem(),frete.getCidadeDestino()).getQuilometros() * (1 + frete.getCategoria().getPercentualAdicional());

        return (double)Math.round(valor * 1000d) / 1000d;
    }
private Distancia getDistancia(Cidade cidadeOrigem, Cidade cidadeDestino) {
    List<Distancia> distancias = cidadeRepository.buscarDistanciasPorCidade(cidadeOrigem.getId());
    // Itera pelas distâncias para encontrar a que corresponde à cidade de destino
    for (Distancia distancia : distancias) {
        if (distancia.getDestino().getId().equals(cidadeDestino.getId())) {
            return distancia;
        }
    }
    // Caso nenhuma distância seja encontrada, imprime a mensagem e retorna null
    System.out.println("Percurso não encontrado");
    return null;
}
    // Retorna uma lista com todos os fretes de um determinado cliente
    public List<Frete> buscarFretesPorCliente(String cpfCliente) {
        return freteRepository.buscarPorCliente(cpfCliente);
    }
    // Buscar Frete por ID
    public Frete buscarFretePorId(Integer id) {
        return freteRepository.buscaPorId(id);
    }
}