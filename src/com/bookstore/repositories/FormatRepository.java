package com.bookstore.repositories;

import com.bookstore.bases.RepositoryBase;
import com.bookstore.daos.Format;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FormatRepository extends RepositoryBase {
    public boolean insert(Format item) {
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
            Format item = entityManager.find(Format.class, id);
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
    public  boolean updateItem(Format item){
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

    public List<Format> getAll()
    {
        List<Format> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Format> query = entityManager.createQuery("SELECT co FROM Format co",Format.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Format getById(int id){
        try{
            return entityManager.find(Format.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
