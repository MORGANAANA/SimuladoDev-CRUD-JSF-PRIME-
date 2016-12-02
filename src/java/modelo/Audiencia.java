/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 10070185
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author 10070185
 */
@Entity
@Table(name = "audiencia")
public class Audiencia {

    @Id
    @GeneratedValue
    private int codigo;
    private DateTimeAtCompleted dataHora;
    private String local;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public DateTimeAtCompleted getDataHora() {
        return dataHora;
    }

    public void setDataHora(DateTimeAtCompleted dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
