package dcomp.core.entity;

import java.util.LinkedList;

public class Cidade {
    private int id;
    private String uf;
    private String nome;
    private String estado;
    private LinkedList<Distancia> distancias = new LinkedList<>();

}
