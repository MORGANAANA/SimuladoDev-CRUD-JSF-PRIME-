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
import modelo.Advogado;
import org.hibernate.Session;

public class AdvogadoDAO {

private final Session sessao;
    
    public AdvogadoDAO(Session sessao) {
       this.sessao = sessao;
    }
    
    public void salvar(Advogado l) {
        sessao.saveOrUpdate(l);
    }
    
    public Advogado carregar(int id) {
        return (Advogado) sessao.load(Advogado.class, id);
    }
    
    public void remover(Advogado l) {
        sessao.delete(l);
    }
    
    public List<Advogado> listar() {
        return sessao.createCriteria(Advogado.class).list();
    }
}
