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
import modelo.Processo;
import org.hibernate.Session;

public class ProcessoDAO {

    private final Session sessao;

    public ProcessoDAO(Session sessao) {
        this.sessao = sessao;
    }

    public void salvar(Processo l) {
        sessao.saveOrUpdate(l);
    }

    public Processo carregar(int id) {
        return (Processo) sessao.load(Processo.class, id);
    }

    public void remover(Processo l) {
        sessao.delete(l);
    }

    public List<Processo> listar() {
        return sessao.createCriteria(Processo.class).list();
    }
}
