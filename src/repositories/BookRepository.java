package repositories;


import bases.RepositoryBase;
import entities.Book;

import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class BookRepository extends RepositoryBase {

    public boolean insertItem(Book item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public List<Book> getAllItems()
    {
        List<Book> items = new ArrayList<>();
        try{
            entityManager.clear();
            entityManager.getTransaction().begin();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c",Book.class);
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
            Book book = entityManager.find(Book.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(book);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public Book getItemById(int id){
        try{
            return entityManager.find(Book.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public  boolean updateItem(Book item){
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

    public List<Book> getNewBooks()
    {
        List<Book> items = new ArrayList<>();
        try{
            int year = LocalDateTime.now().getYear();
            int moth = LocalDateTime.now().getMonthValue();
            int day = LocalDateTime.now().getDayOfMonth()-5;
            Date date = new GregorianCalendar(year, moth, day).getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String d = dateFormat.format(date);

            System.out.println(dateFormat.format(date));
            entityManager.clear();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c WHERE  c.RegDate = current_date ",Book.class);
            items = query.getResultList();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public List<Book> getPopularityBooks()
    {
        List<Book> items = new ArrayList<>();
        try{
            entityManager.clear();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c WHERE c.Price <= 100",Book.class);
            items = query.getResultList();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public List<Book> getFormatBooks(int format)
    {
        List<Book> items = new ArrayList<>();
        try{
            entityManager.clear();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c WHERE c.Format = :format",Book.class)
                    .setParameter("format",format);
            items = query.getResultList();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public byte[] getArrayImage(long id){
        try{
            return entityManager.find(Book.class, id).getImage();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
