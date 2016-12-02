/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import persistencia.ClienteDAO;
import persistencia.SessaoHibernateUtil;
//import persistencia.SessaoHibernateUtil;

/**
 *
 * @author 10070185
 */
@ManagedBean(name = "clienteBean")
@SessionScoped
public class CadastroClienteBean {

    private Cliente cliente = new Cliente();
    private ClienteDAO dao;
    private List<Cliente> listaCliente;
    
    public CadastroClienteBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new ClienteDAO(controleSessaoHibernate.getSession());
        listaCliente = dao.listar();
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

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
    public void novoCliente() {
        cliente = new Cliente();
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public String salvar() {
        boolean novo = cliente.ehNovo();
        dao.salvar(cliente);
        if(novo) {
            listaCliente.add(cliente);
            cliente = new Cliente();
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso");
            return null;
        } else {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Cliente atualizado com sucesso");
            return "pagina";
        }
        
    }
    
    public void carregar(int id) {
        cliente = dao.carregar(id);
    }
    
    public void remover(Cliente cliente) {
        dao.remover(cliente);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Cliente removido com sucesso");
        listaCliente.remove(cliente);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
}

