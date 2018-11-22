package repositories;


import bases.RepositoryBase;
import entities.State;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StateRepository extends RepositoryBase {
    public boolean insertItem(State item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public List<State> getAllItems()
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
    public State getItemById(int id){
        try{
            return entityManager.find(State.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public boolean deleteItem(int id)
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
