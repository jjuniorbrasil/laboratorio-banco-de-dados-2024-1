package dcomp.core.entity;

import lombok.Data;

import java.io.Serializable;

@Data
 class DependentePK implements Serializable{
    private int id;
    private String cpfTutor;
}
