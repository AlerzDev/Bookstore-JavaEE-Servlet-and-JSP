package repositories;

import bases.RepositoryBase;
import entities.UserBookstore;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserBookstoreRepository extends RepositoryBase {

    public boolean insertItem(UserBookstore item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            return  false;
        }
    }

    public UserBookstore getUser(String username, String password){
        List<UserBookstore> items;
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<UserBookstore> query =
                    entityManager.createQuery("SELECT co FROM UserBookstore co WHERE co.Username = :username AND co.Password = :password",UserBookstore.class)
                    .setParameter("username",username)
                    .setParameter("password",password);
            items = query.getResultList();
            entityManager.getTransaction().commit();
            if(items.size() > 0) {
                return items.get(0);
            }else{
                return null;
            }

        }catch (Exception ex){
            return null;
        }
    }

    public UserBookstore getItemById(int id){
        try{
            return entityManager.find(UserBookstore.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<UserBookstore> getAllItems()
    {
        List<UserBookstore> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<UserBookstore> query = entityManager.createQuery("SELECT co FROM UserBookstore co",UserBookstore.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public boolean deleteItem(int id)
    {
        try{
            UserBookstore item = entityManager.find(UserBookstore.class, id);
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

    public  boolean updateItem(UserBookstore item){
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
