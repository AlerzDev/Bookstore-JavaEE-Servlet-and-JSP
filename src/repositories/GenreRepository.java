package repositories;


import bases.RepositoryBase;
import entities.Genre;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class GenreRepository extends RepositoryBase {
    public boolean insert(Genre item) {
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
            Genre item = entityManager.find(Genre.class, id);
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
    public  boolean updateItem(Genre item){
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

    public List<Genre> getAll()
    {
        List<Genre> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Genre> query = entityManager.createQuery("SELECT co FROM Genre co",Genre.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public Genre getById(int id){
        try{
            return entityManager.find(Genre.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
