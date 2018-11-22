package repositories;



import bases.RepositoryBase;
import entities.Author;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository extends RepositoryBase {

    public boolean insert(Author item) {
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
            Author item = entityManager.find(Author.class, id);
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

    public  boolean updateItem(Author item){
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

    public List<Author> getAll()
    {
        List<Author> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Author> query = entityManager.createQuery("SELECT co FROM Author co",Author.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Author getById(int id){
        try{
            return entityManager.find(Author.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
