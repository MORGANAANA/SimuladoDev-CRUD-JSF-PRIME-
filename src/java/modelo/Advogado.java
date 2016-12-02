/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 10070185
 */
@Entity
@Table(name = "advogado")
public class Advogado {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private String registroOAB;

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
     public boolean ehNovo() {
        return codigo == 0;
    }

}
