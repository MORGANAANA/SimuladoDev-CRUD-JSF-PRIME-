package beans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Processo;
import persistencia.ProcessoDAO;
import persistencia.SessaoHibernateUtil;

@ManagedBean(name = "ProcessoBean")
@SessionScoped
public class CadastroProcessoBean {

    private Processo processo = new Processo();
    private ProcessoDAO dao;
    private List<Processo> listaProcesso;
    
    public CadastroProcessoBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new ProcessoDAO(controleSessaoHibernate.getSession());
        listaProcesso = dao.listar();
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public ProcessoDAO getDao() {
        return dao;
    }

    public void setDao(ProcessoDAO dao) {
        this.dao = dao;
    }

    public List<Processo> getListaProcesso() {
        return listaProcesso;
    }
     public void novoProcesso() {
        processo = new Processo();
    }

    public void setListaProcesso(List<Processo> ListaProcesso) {
        this.listaProcesso = ListaProcesso;
    }
public String salvar() {
        boolean novo = processo.ehNovo();
        dao.salvar(processo);
        if(novo) {
            listaProcesso.add(processo);
            processo = new Processo();
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Processo cadastrado com sucesso");
            return null;
        } else {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Processo atualizado com sucesso");
            return "pagina";
        }
        
    }
    
    public void carregar(int id) {
        processo = dao.carregar(id);
    }
    
    public void remover(Processo processo) {
        dao.remover(processo);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "processo removido com sucesso");
        listaProcesso.remove(processo);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
}