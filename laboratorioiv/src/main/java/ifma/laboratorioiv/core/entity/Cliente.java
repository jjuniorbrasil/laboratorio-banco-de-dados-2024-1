package ifma.laboratorioiv.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "Clientes")
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Cliente implements BaseEntity {
    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Column(nullable = false)
    private String nome;

    @Getter @Column(nullable = false, unique = true)
    private String CPF;

    @Getter @Setter @Column(nullable = false)
    private String telefone;

    @Getter @Setter @Column(name = "e-mail")
    private String email;

    @Getter @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Builder.Default
    @Getter @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL)
    private Set<Locacao> locacoes= new LinkedHashSet<>();

    @Builder.Default
    @Getter @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private Set<Imovel> imoveis = new LinkedHashSet<>();
}
