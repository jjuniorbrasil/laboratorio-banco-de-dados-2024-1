package ifma.laboratorioiv.repository;


import ifma.laboratorioiv.core.entity.Cliente;
import jakarta.persistence.EntityManager;

@Deprecated
public class ClienteRepository {

    private final EntityManager eManager;
    private GenericDAO<Cliente> daoGenerico;

    public ClienteRepository(EntityManager manager) {
        this.eManager = manager;
        daoGenerico = new GenericDAO<>(manager);
    }

    public Cliente salvarOuAlterar(Cliente cliente) {
        return daoGenerico.salvarOuAlterar(cliente);
    }
    public Cliente buscaPorId(Integer id) { return daoGenerico.buscaPorId(Cliente.class, id); }
}
