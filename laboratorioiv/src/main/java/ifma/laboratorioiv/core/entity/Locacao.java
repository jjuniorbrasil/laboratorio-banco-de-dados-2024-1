package ifma.laboratorioiv.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "Locacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Locacao implements BaseEntity {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Getter
    private Integer id;

    @Getter @Setter @Column(name = "valor_aluguel",nullable = false)
    private BigDecimal valorAluguel;

    @Getter @Setter @Column(name = "percentual_multa",columnDefinition = "Decimal(5,2)")
    private double percentualMulta;

    @Getter @Setter @Column(name = "dia_vencimento", nullable = false, columnDefinition = "TINYINT")
    private short diaVencimento;

    @Getter @Setter @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Getter @Setter @Column(name = "data_fim")
    private Date dataFim;

    @Getter @Setter @Column(nullable = false)
    private boolean ativo;

    @Getter @Setter
    private String observacao;

    @Getter @OneToMany(mappedBy = "locacao",cascade = CascadeType.ALL)
    private Set <Aluguel> alugueis = new LinkedHashSet<>();

    @Getter @ManyToOne @JoinColumn(name = "ID_inquilino")
    private Cliente inquilino;

    @Getter @ManyToOne @JoinColumn(name = "ID_imovel")
    private Imovel imovel;
}
