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
import modelo.Audiencia;
import org.hibernate.Session;

public class AudienciaDAO {
     private final Session sessao;

    public AudienciaDAO(Session sessao) {
        this.sessao = sessao;
    }

    public void salvar(Audiencia l) {
        sessao.saveOrUpdate(l);
    }

    public Audiencia carregar(int id) {
        return (Audiencia) sessao.load(Audiencia.class, id);
    }

    public void remover(Audiencia l) {
        sessao.delete(l);
    }

    public List<Audiencia> listar() {
        return sessao.createCriteria(Audiencia.class).list();
    }
}

