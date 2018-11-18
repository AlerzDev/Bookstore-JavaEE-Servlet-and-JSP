package com.bookstore.repositories;

import com.bookstore.bases.RepositoryBase;
import com.bookstore.daos.State;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StateRepository extends RepositoryBase {
    public boolean insert(State item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public List<State> getAll()
    {
        List<State> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<State> query = entityManager.createQuery("SELECT co FROM State co",State.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }
    public State getById(int id){
        try{
            return entityManager.find(State.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public boolean delete(int id)
    {
        try{
            State item = entityManager.find(State.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(item);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    public  boolean updateItem(State item){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(item);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
