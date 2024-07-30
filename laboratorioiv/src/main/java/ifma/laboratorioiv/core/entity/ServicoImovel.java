package ifma.laboratorioiv.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoImovel implements BaseEntity {
    @Id @Getter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter @Column(name = "data_servico")
    private Date dataServico;

    @Getter @Setter @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Getter @Setter
    private  String observacao;

    @Getter @Setter @ManyToOne @JoinColumn(name = "ID_profissional", nullable = false)
    private Profissional profissional;

    @Getter @Setter @ManyToOne @JoinColumn(name = "ID_imovel", nullable = false)
    private Imovel imovel;
}
