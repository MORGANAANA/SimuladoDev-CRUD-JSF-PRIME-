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

    public CadastroAdvogadoBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new AdvogadoDAO(controleSessaoHibernate.getSession());
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
     public void salvar() {
        dao.incluir(advogado);
        advogado = new Advogado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Advogado incluído com sucesso!", ""));
    }
    

   
}
