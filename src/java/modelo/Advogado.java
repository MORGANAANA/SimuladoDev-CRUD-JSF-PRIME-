/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author 10070185
 */
@Entity
@Table(name = "advogados")
public class Advogado {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private String registroOAB;
    
    //Relação, um advogado ter vários processos assim como processos tem vários advogados
    //Mapeado pelo advogado, então apartir do advogado iremos ver os processos, e não o contrário
    @ManyToMany(mappedBy = "advogados")
    private List<Processo> processos;
    
     //CRIAR OS GETTERS E SETTERS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroOAB() {
        return registroOAB;
    }

    public void setRegistroOAB(String registroOAB) {
        this.registroOAB = registroOAB;
    }
    

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }
     

}
