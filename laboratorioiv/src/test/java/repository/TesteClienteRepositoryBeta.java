package repository;

import ifma.laboratorioiv.core.entity.Cliente;
import ifma.laboratorioiv.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Deprecated
public class TesteClienteRepositoryBeta {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("laboratorioiv");
        EntityManager em = emf.createEntityManager();

        //Cliente c = new Cliente(15,"Jubileia","04950-450","930001293",null,null,null,null);

        em.getTransaction().begin();
        ClienteRepository cr = new ClienteRepository(em);
        //cr.salvarOuAlterar(c);
        Cliente c2 = cr.buscaPorId(1);
        em.getTransaction().commit();

        System.out.println(c2.getNome());
        em.close();
        emf.close();
    }
}
