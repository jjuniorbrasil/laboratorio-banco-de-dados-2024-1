import dcomp.core.entity.Frete;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TestesJPQL {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();

        String jpql = "SELECT f from Frete f where f.numeroNotaFiscal = :num";
        TypedQuery<Frete> query = em.createQuery(jpql, Frete.class).setParameter("num", 5324212);


        em.close();
        factory.close();
    }
}
