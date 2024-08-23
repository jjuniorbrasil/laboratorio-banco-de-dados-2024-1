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
@Table(name = "frete")
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

    @Getter @Setter @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "placa_veiculo", referencedColumnName = "numero_placa"),
            @JoinColumn(name = "id_filial", referencedColumnName = "id_filial")
    })
    private Veiculo veiculo;


    public BigDecimal calcularFrete(){
        BigDecimal distancia=BigDecimal.valueOf(DistanciaDestino_Origem());
        return valorKmRodado.multiply(distancia);
    }

    private int DistanciaDestino_Origem(){
        int quilometros=0;
        for(Distancia distancia : cidadeOrigem.getDistancias()){
            if(distancia.getDestino()==cidadeDestino){
                quilometros=distancia.getQuilometros();
            }
        }
        return quilometros;
    }



    @Override
    public Integer getKey() {
        return this.codigo;
    }
}
