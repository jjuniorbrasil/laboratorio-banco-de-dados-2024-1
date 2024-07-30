package ifma.laboratorioiv.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "Alugueis")
@NoArgsConstructor @AllArgsConstructor
public class Aluguel implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  @Getter
    private Integer id;

   @Getter @Setter @Column (name = "data_vencimento", nullable = false)
   private Date dataVencimento;

   @Getter @Setter @Column (name ="valor_pago")
   private BigDecimal valorPago;

   @Getter @Setter @Column (name = "data_pagamento")
   private Date dataPagamento;

   @Getter @Setter
   private String observacao;

   @ManyToOne @Getter @Setter @JoinColumn (name = "ID_locacao",nullable = false)
   private Locacao locacao;


}
