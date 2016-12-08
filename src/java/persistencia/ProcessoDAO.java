package persistencia;

import java.util.List;
import modelo.Processo;
import org.hibernate.Session;

/**
 *
 * @author leonardo
 */
public class ProcessoDAO {
    private Session sessao;
    
    public ProcessoDAO(Session sessao) {
        this.sessao = sessao;
    }
    
    public void incluir(Processo p) {
        sessao.save(p);
    }
    
    public Processo carregar(int codigo) {
        return (Processo) sessao.get(Processo.class, codigo);
    }
    
    public List<Processo> listar() {
        return sessao.createCriteria(Processo.class).list();
    }

    public void alterar(Processo p) {
        sessao.update(p);
    }
}
