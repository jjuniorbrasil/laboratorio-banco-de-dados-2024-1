package ifma.laboratorioiv.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
public class Endereco {
    @Getter @Column(nullable = false)
    private String CEP;

    @Getter @Column(nullable = false)
    private String bairro;

    @Getter @Column(nullable = false)
    private String logradouro;
}
