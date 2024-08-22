package dcomp.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Cidade implements EntidadeBase  {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String uf;

    @Getter
    private String nome;

    @Getter
    private String estado;

    @OneToMany(mappedBy = "Origem")
    private LinkedList<Distancia> distancias = new LinkedList<>();


    @Override
    public Integer getKey() {
        return this.id;
    }
}
