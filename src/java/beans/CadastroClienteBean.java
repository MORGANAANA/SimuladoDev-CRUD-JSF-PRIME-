/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import persistencia.ClienteDAO;
import persistencia.SessaoHibernateUtil;

/**
 * Inserindo Atributos da classe cliente Criando o Construtor Criando Getters e
 * Setters
 *
 *
 */
@ManagedBean(name = "clienteBean")
@RequestScoped
public class CadastroClienteBean {

    private Cliente cliente = new Cliente();
    private ClienteDAO dao;

    public CadastroClienteBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new ClienteDAO(controleSessaoHibernate.getSession());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDAO getDao() {
        return dao;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }

    public void salvar() {
        dao.incluir(cliente);
        cliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente incluído com sucesso!", ""));
    }

    public List<Cliente> getListaClientes() {
        return dao.listar();
    }

}
