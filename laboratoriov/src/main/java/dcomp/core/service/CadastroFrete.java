package dcomp.core.service;

import dcomp.core.entity.*;
import dcomp.core.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import dcomp.core.repository.FreteRepository;

import java.math.BigDecimal;
import java.util.List;

public class CadastroFrete {
    private final FreteRepository freteRepository;
    private final CidadeRepository cidadeRepository;
    private final EntityManager em;
    private static final double VALOR_POR_KM = 5.0; // Valor padrão por km rodado

    public CadastroFrete(FreteRepository freteRepository, CidadeRepository cidadeRepository, EntityManager em) {
        this.freteRepository = freteRepository;
        this.cidadeRepository = cidadeRepository;
        this.em = em;
    }

    // Registra um novo frete
    public void registrarFrete(Cliente cliente, CategoriaFrete categoriaFrete, Veiculo veiculo, Cidade cidadeOrigem, Cidade cidadeDestino, int numeroNotaFiscal, BigDecimal valorKmRodado, Integer codigo) {
        em.getTransaction().begin();
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
        em.getTransaction().commit();
    }

    // Calcula o valor do frete com base na distância entre as cidades e na categoria do frete
    public double calcularValorFrete(Frete frete) {
       double valor = frete.getValorKmRodado().doubleValue() * getDistancia(frete.getCidadeOrigem(),frete.getCidadeDestino()).getQuilometros() * (1 + frete.getCategoria().getPercentualAdicional());

        return (double)Math.round(valor * 1000d) / 1000d;
    }
private Distancia getDistancia(Cidade cidadeOrigem, Cidade cidadeDestino) {
    List<Distancia> distancias = cidadeOrigem.getDistancias();
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