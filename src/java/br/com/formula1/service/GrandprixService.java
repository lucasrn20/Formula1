package br.com.formula1.service;

import br.com.formula1.dao.GrandprixDao;
import br.com.formula1.domain.Grandprix;
import java.util.List;

public class GrandprixService {
    
    private GrandprixDao grandprixDao = new GrandprixDao();
    
    public List<Grandprix> listar(){
        return grandprixDao.listar();
    }
    
    public Grandprix consultar(Integer id){
        return grandprixDao.consultar(id);
    }
    
    public boolean inserir(Grandprix grandprix){
        return grandprixDao.inserir(grandprix);
    }
    
    public boolean alterar(Grandprix grandprix){
        return grandprixDao.alterar(grandprix);
    }
    
    public boolean excluir(Grandprix grandprix){
        return grandprixDao.excluir(grandprix);
    }
}
