package dcomp.core.entity;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Frete {
    private int codigo;
    private int numeroNotaFiscal;
    private BigDecimal valorKmRodado;
    private CategoriaFrete categoria;
    private LinkedList<ItemFrete> itens = new LinkedList<>();
    private Cliente cliente;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private Veiculo veiculo;


    public void calcularFrete(){

    }
}
