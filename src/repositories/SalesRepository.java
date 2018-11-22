package repositories;

import bases.RepositoryBase;
import entities.Sales;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository extends RepositoryBase {
    public boolean insert(Sales item) {
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
            Sales item = entityManager.find(Sales.class, id);
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

    public  boolean updateItem(Sales item){
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

    public List<Sales> getAll()
    {
        List<Sales> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Sales> query = entityManager.createQuery("SELECT co FROM Sales co",Sales.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public List<Sales> getItemsByID(long id)
    {
        List<Sales> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Sales> query = entityManager.createQuery("SELECT co FROM Sales co WHERE co.UserBookstore = :id",Sales.class).setParameter("id",id);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Sales getById(long id){
        try{
            return entityManager.find(Sales.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
