package repositories;


import bases.RepositoryBase;
import entities.Country;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository extends RepositoryBase {

    public boolean insertItem(Country item) {
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
            Country item = entityManager.find(Country.class, id);
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
    public  boolean updateItem(Country item){
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

    public List<Country> getAllItems()
    {
        List<Country> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Country> query = entityManager.createQuery("SELECT co FROM Country co",Country.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Country getItemById(int id){
        try{
            return entityManager.find(Country.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
