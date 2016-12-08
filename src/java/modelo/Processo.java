package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leonardo
 */
@Entity
@Table(name="processos")
public class Processo {
    @Id
    @GeneratedValue
    private int codigo;
    private String descricao;
    private Date dataDeAbertura;
    
   //Associando Vários Processos a um Cliente
    //Inserindo uma coluna codigo_cliente (Chave extrangeira)da tabela CLIENTE
    @ManyToOne()
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;

    //O processo pode ter várias audiencias
    //Neste caso iremos chamar uma LISTA contento todas as audiencias associadas a este processo
     @OneToMany(mappedBy="processo")
    private List<Audiencia> audiencias;


//Esta tabela é alimentada pela PROCESSOS e Advogados
//Pegamos o código do Processo e Apresentamos um LIST dos advogados que podem estar nesse processo.    
//Mapeamento advogado, criando a TABELA DE ACOSSIAÇÃO que pega as chaves das tabelas.
 //Esta tabela é a que junta duas tabelas, pegando a chave estrangeira de cta uma
    
    @ManyToMany
    @JoinTable(name="processos_advogados", joinColumns=
      {@JoinColumn(name="codigo_processo")}, inverseJoinColumns=
        {@JoinColumn(name="codigo_advogado")})
    private List<Advogado> advogados = new ArrayList();
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Audiencia> getAudiencias() {
        return audiencias;
    }

    public void setAudiencias(List<Audiencia> audiencias) {
        this.audiencias = audiencias;
    }

    public List<Advogado> getAdvogados() {
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }   

    public void adicionarAdvogado(Advogado adv) {
        advogados.add(adv);
    }
}
