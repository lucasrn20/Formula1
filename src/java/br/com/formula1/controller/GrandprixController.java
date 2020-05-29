package br.com.formula1.controller;

import br.com.formula1.domain.Grandprix;
import br.com.formula1.service.GrandprixService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="grandprixMB")
@SessionScoped
public class GrandprixController implements Serializable{
    
    private Grandprix grandprix = new Grandprix();
    private List<Grandprix> grandprixs;
    private GrandprixService grandprixService = new GrandprixService();
    
    public GrandprixController(){
        listar();
    }
    
    public void listar(){
        grandprixs = grandprixService.listar();
    }
    
    public String novo(){
        grandprix = new Grandprix();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Grandprix funcionario){
        this.grandprix = funcionario;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(grandprixService.inserir(grandprix)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o grandprix!");
        return null;
    }
    
    public String alterar(){
        if(grandprixService.alterar(grandprix)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o grandprix!");
        return null;
    }
    
    public String excluir(Grandprix grandprix){
        if(grandprixService.excluir(grandprix)){
            UtilMensagens.mensagemSucesso("Sucesso", "Grandprix excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o grandprix!");
        return null;
    }

    public Grandprix getGrandprix() {
        return grandprix;
    }

    public void setGrandprix(Grandprix grandprix) {
        this.grandprix = grandprix;
    }

    public List<Grandprix> getGrandprixs() {
        return grandprixs;
    }

    public void setGrandprixs(List<Grandprix> grandprixs) {
        this.grandprixs = grandprixs;
    }


}
