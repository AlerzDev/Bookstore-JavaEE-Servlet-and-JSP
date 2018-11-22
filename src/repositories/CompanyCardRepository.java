package repositories;

import bases.RepositoryBase;
import entities.CompanyCard;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CompanyCardRepository extends RepositoryBase {
    public boolean insert(CompanyCard item) {
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
            CompanyCard  item = entityManager.find(CompanyCard.class, id);
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

    public  boolean updateItem(CompanyCard  item){
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

    public List<CompanyCard> getAll()
    {
        List<CompanyCard> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<CompanyCard > query = entityManager.createQuery("SELECT co FROM CompanyCard co",CompanyCard.class);
            items = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public CompanyCard  getById(int id){
        try{
            return entityManager.find(CompanyCard.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
