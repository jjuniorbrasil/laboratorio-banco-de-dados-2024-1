package ifma.laboratorioiv.core.entity.enums;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
public enum TipoImovel {

    TIPO1(1, "descricao1"), TIPO2(2, "descricao2"), TIPO3(3, "descricao3");

    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String descricao;
}
