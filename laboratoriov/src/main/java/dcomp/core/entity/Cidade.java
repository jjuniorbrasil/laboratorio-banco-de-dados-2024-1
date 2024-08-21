package dcomp.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Cidade {
    @Getter
    private int id;

    @Getter
    private String uf;

    @Getter
    private String nome;

    @Getter
    private String estado;

    @OneToMany
    private LinkedList<Distancia> distancias = new LinkedList<>();

}
