package persistencia;

//Todos os Métodos acossiados ao Cliente

import java.util.List;
import modelo.Cliente;
import org.hibernate.Session;

public class ClienteDAO {

    private Session sessao;

    public ClienteDAO(Session sessao) {
        this.sessao = sessao;
    }

    public void incluir(Cliente c) {
        sessao.save(c);
    }

    public List<Cliente> listar() {
        return sessao.createCriteria(Cliente.class).list();
    }

    public Cliente carregar(int codigo) {
        return (Cliente) sessao.get(Cliente.class, codigo);
    }
}
