package dcomp.core.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
 class DependentePK implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpfTutor;
}
