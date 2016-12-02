/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author 10070185
 */
import java.util.List;
import modelo.Cliente;
import org.hibernate.Session;

public class ClienteDAO {
private final Session sessao;
    
    public ClienteDAO(Session sessao) {
       this.sessao = sessao;
    }
    
    public void salvar(Cliente l) {
        sessao.saveOrUpdate(l);
    }
    
    public Cliente carregar(int id) {
        return (Cliente) sessao.load(Cliente.class, id);
    }
    
    public void remover(Cliente l) {
        sessao.delete(l);
    }
    
    public List<Cliente> listar() {
        return sessao.createCriteria(Cliente.class).list();
    }
}
