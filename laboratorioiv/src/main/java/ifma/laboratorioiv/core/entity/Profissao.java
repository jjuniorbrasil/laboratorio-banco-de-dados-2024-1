package ifma.laboratorioiv.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
public class Profissao {

    @Column (name="profissao",nullable = false)
   private String nome;

    @Column (name = "valor_hora",nullable = false,columnDefinition = "Decimal(10,2)")
    private BigDecimal valorHora;
}
