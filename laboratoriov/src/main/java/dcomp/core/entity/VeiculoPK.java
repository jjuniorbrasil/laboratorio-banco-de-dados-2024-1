package dcomp.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
class VeiculoPK implements Serializable {
    @Column(name = "numero_placa")
    private String numeroPlaca;
    private Integer filialId;

}
