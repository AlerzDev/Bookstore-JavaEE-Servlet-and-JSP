package com.bookstore.repositories;

import com.bookstore.bases.RepositoryBase;
import com.bookstore.daos.Editorial;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EditorialRepository extends RepositoryBase {
    public boolean insert(Editorial item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id)
    {
        try{
            Editorial item = entityManager.find(Editorial.class, id);
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
    public  boolean updateItem(Editorial item){
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

    public List<Editorial> getAll()
    {
        List<Editorial> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Editorial> query = entityManager.createQuery("SELECT co FROM Editorial co",Editorial.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Editorial getById(int id){
        try{
            return entityManager.find(Editorial.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
