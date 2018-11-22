package repositories;

import bases.RepositoryBase;
import entities.Bank;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class BankRepository extends RepositoryBase {

    public boolean insert(Bank item) {
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
            Bank item = entityManager.find(Bank.class, id);
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

    public  boolean updateItem(Bank item){
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

    public List<Bank> getAll()
    {
        List<Bank> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Bank> query = entityManager.createQuery("SELECT co FROM Bank co",Bank.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Bank getById(int id){
        try{
            return entityManager.find(Bank.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
