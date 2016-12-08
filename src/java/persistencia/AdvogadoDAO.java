/*
 A Classe persistencia AdvogadoDAO, fornece todos os métodos acossiado ao Advogado
 */
package persistencia;

import modelo.Advogado;
import org.hibernate.Session;

public class AdvogadoDAO {
    private Session sessao;
 
    public AdvogadoDAO(Session sessao) {
        this.sessao = sessao;
    }
    
    public void incluir(Advogado a) {
        sessao.save(a);
    }
    
    public Advogado consultarPorOAB(String registroOAB) {
        return (Advogado) sessao.createQuery("FROM Advogado WHERE registroOAB = :oab")
                                    .setString("oab", registroOAB)
                                    .uniqueResult();
    }
}
