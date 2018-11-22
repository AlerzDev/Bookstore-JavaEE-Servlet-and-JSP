package repositories;

import bases.RepositoryBase;
import entities.TypeCard;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TypeCardRepository extends RepositoryBase {

    public boolean insert(TypeCard item) {
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
            TypeCard item = entityManager.find(TypeCard.class, id);
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

    public  boolean updateItem(TypeCard item){
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

    public List<TypeCard> getAll()
    {
        List<TypeCard> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<TypeCard> query = entityManager.createQuery("SELECT co FROM TypeCard co",TypeCard.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public TypeCard getById(int id){
        try{
            return entityManager.find(TypeCard.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
