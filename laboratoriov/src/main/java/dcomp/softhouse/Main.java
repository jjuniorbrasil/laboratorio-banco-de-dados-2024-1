package dcomp.softhouse;

import dcomp.core.entity.Filial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Filial filial = new Filial(null,"Pedreiros De Sodftare Company","Na puta que pariu","98822-3405");
        em.persist(filial);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}