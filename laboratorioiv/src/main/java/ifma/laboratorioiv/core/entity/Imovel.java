package ifma.laboratorioiv.core.entity;

import ifma.laboratorioiv.core.entity.enums.TipoImovel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Imoveis")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imovel implements BaseEntity {
    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private Integer metragem;

    @Getter @Setter
    private Integer dormitorios;

    @Getter @Setter
    private Integer banheiros;

    @Getter @Setter
    private Integer suites;

    @Getter @Setter @Column(name = "vagas_garagem", nullable = true)
    private Integer vagasGaragem;

    @Getter @Setter @Column(name = "valor_aluguel_sugerido")
    private BigDecimal valorAluguelSugerido;

    @Getter @Setter
    String observacao;

    @Getter @Embedded
    Endereco endereco;

    @Getter @Setter @Column(name = "ID_tipo_imovel", nullable = false) @Enumerated(EnumType.STRING)
    TipoImovel tipo;

    @Getter @OneToMany(mappedBy="imovel")
    List<Locacao> locacoes;

    @Getter @ManyToOne @JoinColumn(name="ID_proprietario", nullable = false)
    Cliente proprietario;
}
