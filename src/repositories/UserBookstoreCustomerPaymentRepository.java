package repositories;

import bases.RepositoryBase;
import entities.UserBookstoreCustomerPayment;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserBookstoreCustomerPaymentRepository extends RepositoryBase {

    public boolean insert(UserBookstoreCustomerPayment item) {
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
            UserBookstoreCustomerPayment item = entityManager.find(UserBookstoreCustomerPayment.class, id);
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

    public  boolean updateItem(UserBookstoreCustomerPayment item){
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

    public List<UserBookstoreCustomerPayment> getAll()
    {
        List<UserBookstoreCustomerPayment> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<UserBookstoreCustomerPayment> query = entityManager.createQuery("SELECT co FROM UserBookstoreCustomerPayment co",UserBookstoreCustomerPayment.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public List<UserBookstoreCustomerPayment> getItemsByID(long id)
    {
        List<UserBookstoreCustomerPayment> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<UserBookstoreCustomerPayment> query = entityManager.createQuery("SELECT co FROM UserBookstoreCustomerPayment co WHERE co.UserBookstore = :id",UserBookstoreCustomerPayment.class).setParameter("id",id);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public UserBookstoreCustomerPayment getById(long id){
        try{
            return entityManager.find(UserBookstoreCustomerPayment.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
