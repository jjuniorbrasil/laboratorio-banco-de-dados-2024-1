package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Frete implements EntidadeBase {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Getter @Setter @Column(name="numero_nota_fiscal",nullable = false)
    private int numeroNotaFiscal;

    @Getter @Setter @Column(name="valor_Km_rodado",nullable = false)
    private BigDecimal valorKmRodado;

    @ManyToOne @JoinColumn(name = "id_categoria")
    private CategoriaFrete categoria;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @Getter @Setter @ManyToOne @JoinColumn(name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @Getter @Setter @ManyToOne @JoinColumn(name = "placa_veiculo")
    private Veiculo veiculo;


    public void calcularFrete(){

    }

    @Override
    public Integer getKey() {
        return this.codigo;
    }
}
