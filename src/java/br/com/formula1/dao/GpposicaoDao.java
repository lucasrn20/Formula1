/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formula1.dao;

import br.com.formula1.domain.Gpposicao;
import br.com.formula1.domain.Grandprix;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lucas
 */
public class GpposicaoDao {
    public List<Gpposicao> listar(Grandprix grandprix){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Gpposicao> gpposicaos = session.createQuery("from Gpposicao where id = "+grandprix.getId()+" order by classificacao").list();
            session.getTransaction().commit();
            return gpposicaos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Gpposicao gpposicao){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(gpposicao);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }   
    
    public boolean alterar(Gpposicao gpposicao){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(gpposicao);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    } 
     
    public boolean excluir(Grandprix grandprix){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery("delete gpposicao where id = :idGP");
            query.setParameter("idGP", grandprix.getId());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
}
