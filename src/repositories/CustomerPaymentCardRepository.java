package repositories;

import bases.RepositoryBase;
import entities.CustomerPaymentCard;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CustomerPaymentCardRepository extends RepositoryBase {

    public boolean insert(CustomerPaymentCard item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public long insertItem(CustomerPaymentCard item){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
            return item.getId();
        }catch (Exception ex){
            return  0;
        }
    }

    public boolean delete(int id)
    {
        try{
            CustomerPaymentCard item = entityManager.find(CustomerPaymentCard.class, id);
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

    public  boolean updateItem(CustomerPaymentCard item){
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

    public List<CustomerPaymentCard> getAll()
    {
        List<CustomerPaymentCard> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<CustomerPaymentCard> query = entityManager.createQuery("SELECT co FROM CustomerPaymentCard co",CustomerPaymentCard.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public CustomerPaymentCard getById(long id){
        try{
            return entityManager.find(CustomerPaymentCard.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
