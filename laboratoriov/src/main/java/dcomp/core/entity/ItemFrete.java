package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemFrete implements EntidadeBase{

    @Id @Getter
    private Integer id;

    @Getter @Setter @Column(nullable = false)
    private String descricao;

    @Getter @Setter
    private float peso;

    @ManyToOne @MapsId @JoinColumn(name ="id_frete")
    private Frete frete;

    @Override
    public Integer getKey() {
        return this.id;
    }
}
