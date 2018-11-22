package repositories;



import bases.RepositoryBase;
import entities.Language;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class LanguageRepository extends RepositoryBase {

    public boolean insert(Language item) {
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
            Language item = entityManager.find(Language.class, id);
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
    public  boolean updateItem(Language item){
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

    public List<Language> getAll()
    {
        List<Language> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Language> query = entityManager.createQuery("SELECT co FROM Language co",Language.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Language getById(int id){
        try{
            return entityManager.find(Language.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
