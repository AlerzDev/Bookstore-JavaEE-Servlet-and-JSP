package repositories;


import bases.RepositoryBase;
import entities.Municipality;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityRepository extends RepositoryBase {
    public boolean insertItem(Municipality item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public List<Municipality> getAllItems()
    {
        List<Municipality> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Municipality> query = entityManager.createQuery("SELECT co FROM Municipality co",Municipality.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }
    public Municipality getItemById(int id){
        try{
            return entityManager.find(Municipality.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public boolean deleteItem(int id)
    {
        try{
            Municipality item = entityManager.find(Municipality.class, id);
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
    public  boolean updateItem(Municipality item){
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
