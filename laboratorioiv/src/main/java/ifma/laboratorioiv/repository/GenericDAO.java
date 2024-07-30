package ifma.laboratorioiv.repository;

import ifma.laboratorioiv.core.entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.util.Objects;

// Generic será uma interface, também, que limitará o tipo de entidade.
public class GenericDAO<Gereric extends BaseEntity> {

    private final EntityManager eManager;

    public GenericDAO(EntityManager manager) {
        this.eManager = manager;
    }

    Gereric buscaPorId(Class<Gereric> clazz,Integer id) {
        return eManager.find(clazz, id);
    }

    Gereric salvarOuAlterar(Gereric entidade) {
        if(Objects.isNull(entidade.getId()) )
            this.eManager.persist(entidade);
        else
            entidade = this.eManager.merge(entidade);
        return entidade;
    }

    void Remover(Gereric entidade) {
        this.eManager.remove(entidade);
        this.eManager.flush();
    }
}
