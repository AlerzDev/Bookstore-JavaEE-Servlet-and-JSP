package com.bookstore.repositories;

import com.bookstore.bases.RepositoryBase;
import com.bookstore.daos.Book;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class BookRepository extends RepositoryBase {
    public boolean insert(Book item) {
        try{
            return executeInsideTransaction(entityManager -> entityManager.persist(item));
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public List<Book> GetBooksActive()
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
    public boolean delete(int id)
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

    public Book getById(int id){
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

    public List<Book> GetBooksNews()
    {
        List<Book> items = new ArrayList<>();
        try{
            entityManager.clear();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c WHERE c.Year = current_date",Book.class);
            items = query.getResultList();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }

    public List<Book> GetBooksOffers()
    {
        List<Book> items = new ArrayList<>();
        try{
            entityManager.clear();
            TypedQuery<Book> query = entityManager.createQuery("SELECT c FROM Book c WHERE c.Price <= 50",Book.class);
            items = query.getResultList();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  items;
    }
}
