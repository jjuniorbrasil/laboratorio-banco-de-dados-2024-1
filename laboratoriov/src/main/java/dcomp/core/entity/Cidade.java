package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "cidade")
public class Cidade implements EntidadeBase  {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String uf;

    @Getter
    private String nome;

    @Getter
    private String estado;

    @OneToMany(mappedBy = "Origem") @Getter @Setter
    private LinkedList<Distancia> distancias = new LinkedList<>();


    @Override
    public Integer getKey() {
        return this.id;
    }
}
