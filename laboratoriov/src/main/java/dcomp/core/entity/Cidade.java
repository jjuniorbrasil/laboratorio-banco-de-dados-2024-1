package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "cidade")
public class Cidade implements EntidadeBase<Integer>  {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String uf;

    @Getter
    private String nome;

    @Getter
    private String estado;

    @OneToMany(mappedBy = "origem") @Getter @Setter
    private List<Distancia> distancias = new LinkedList<>();

    @Override
    public Integer getKey() {
        return this.id;
    }
}
