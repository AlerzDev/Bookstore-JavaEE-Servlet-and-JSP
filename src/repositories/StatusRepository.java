package repositories;

import bases.RepositoryBase;
import entities.Status;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository extends RepositoryBase {
    public boolean insertItem(Status item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean deleteItem(int id)
    {
        try{
            Status item = entityManager.find(Status.class, id);
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
    public  boolean updateItem(Status item){
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

    public List<Status> getAllItems()
    {
        List<Status> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Status> query = entityManager.createQuery("SELECT co FROM Status co",Status.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Status getItemById(int id){
        try{
            return entityManager.find(Status.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
