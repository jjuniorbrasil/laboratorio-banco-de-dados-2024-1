package repository;

import dcomp.core.entity.*;
import dcomp.core.repository.FreteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class TestaFreteRepository {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratoriov");
        EntityManager em = factory.createEntityManager();
        FreteRepository freteRep = new FreteRepository(em);

        // TODO: Finalizar outros reps dos quais esse aqui depende
        Cliente c = em.find(Cliente.class, "123.456.789-01");
        CategoriaFrete cat = em.find(CategoriaFrete.class, 1);
        Cidade orig = em.find(Cidade.class, 2);
        Cidade dest = em.find(Cidade.class, 1);
        Veiculo veic = null;
        Frete fr = Frete.builder()
                .cliente(c)
                .categoria(cat)
                .cidadeOrigem(orig)
                .cidadeDestino(dest)
                .veiculo(veic)
                .numeroNotaFiscal(1351234)
                .valorKmRodado(new BigDecimal(2))
                .build();
        em.getTransaction().begin();
        freteRep.salvarOuAtualizar(fr);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
