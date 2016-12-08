package beans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Processo;
import persistencia.AdvogadoDAO;
import persistencia.ClienteDAO;
import persistencia.ProcessoDAO;
import persistencia.SessaoHibernateUtil;

/**
 *
 * @author leonardo
 */
@ManagedBean
@SessionScoped
public class CadastroProcessoBean {
    private Processo processo;
    private int idCliente;
    private int codProcesso;
    private String regAdvogado;
    private ProcessoDAO dao;
    private ClienteDAO clienteDAO;
    private AdvogadoDAO advogadoDAO;
    
    public CadastroProcessoBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new ProcessoDAO(controleSessaoHibernate.getSession());
        clienteDAO = new ClienteDAO(controleSessaoHibernate.getSession());
        advogadoDAO = new AdvogadoDAO(controleSessaoHibernate.getSession());
    }
    
    public List<Processo> getListaProcessos() {
        return dao.listar();
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(int codProcesso) {
        this.codProcesso = codProcesso;
    }

    public String getRegAdvogado() {
        return regAdvogado;
    }

    public void setRegAdvogado(String regAdvogado) {
        this.regAdvogado = regAdvogado;
    }
    
    public void novoProcesso() {
        processo = new Processo();
    }
    
    public void carregar(int codigo) {
        processo = dao.carregar(codigo);
    }
    
    public void salvar() {
        processo.setCliente(clienteDAO.carregar(idCliente));
        dao.incluir(processo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Processo incluído com sucesso!", ""));
    }
    
    public void associarAdvogado() {
        Processo p = dao.carregar(codProcesso);
        p.adicionarAdvogado(advogadoDAO.consultarPorOAB(regAdvogado));
        dao.alterar(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Processo atualizado com sucesso!", ""));
    }
}
