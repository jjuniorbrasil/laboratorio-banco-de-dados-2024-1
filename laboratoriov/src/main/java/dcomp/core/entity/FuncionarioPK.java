package dcomp.core.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
class FuncionarioPK implements Serializable {

    private String cpf;
    private Integer filialId;
}
