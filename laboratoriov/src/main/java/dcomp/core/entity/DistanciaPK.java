package dcomp.core.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DistanciaPK implements Serializable {

    private Integer cidadeOrigemId;
    private Integer cidadeDestinoId;
}
