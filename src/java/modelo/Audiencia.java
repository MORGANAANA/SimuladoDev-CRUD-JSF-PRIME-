package modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Morgana
 */
@Entity
@Table(name = "audiencias")
public class Audiencia {

    @Id
    @GeneratedValue
    private int codigo;
    private Date dataHora;
    private String local;

    //Muitas audiencias podem ser do mesmo processo
    //Juntei com a colula do CÓDIGO DO PROCESSO que se encontra na Classe processo
    @ManyToOne
    @JoinColumn(name = "codigo_processo")
    private Processo processo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

}
