package beans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Advogado;
import persistencia.AdvogadoDAO;
import persistencia.SessaoHibernateUtil;

@ManagedBean(name = "AdvogadoBean")
@SessionScoped
public class CadastroAdvogadoBean {

    private Advogado advogado = new Advogado();
    private AdvogadoDAO dao;
    private List<Advogado> listaAdvogado;

    public CadastroAdvogadoBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new AdvogadoDAO(controleSessaoHibernate.getSession());
        listaAdvogado = dao.listar();
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public AdvogadoDAO getDao() {
        return dao;
    }

    public void setDao(AdvogadoDAO dao) {
        this.dao = dao;
    }

    public List<Advogado> getListaAdvogado() {
        return listaAdvogado;
    }

    public void setListaAdvogado(List<Advogado> listaAdvogado) {
        this.listaAdvogado = listaAdvogado;
    }

 public String salvar() {
        boolean novo = advogado.ehNovo();
        dao.salvar(advogado);
        if(novo) {
            listaAdvogado.add(advogado);
            advogado = new Advogado();
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Advogado cadastrado com sucesso");
            return null;
        } else {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Advogado atualizado com sucesso");
            return "pagina";
        }
        
    }
    
    public void carregar(int id) {
        advogado = dao.carregar(id);
    }
    
    public void remover(Advogado advogado) {
        dao.remover(advogado);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Advogado removido com sucesso");
        listaAdvogado.remove(advogado);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
}