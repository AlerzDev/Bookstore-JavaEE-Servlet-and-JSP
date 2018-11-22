package beans;

import entities.Book;
import entities.UserBookstore;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class SessionBean implements Session{

    public SessionBean(){

    }

    private UserBookstore session;

    public List<Book> bookCar = new ArrayList<>();

    @Override
    public void initializeSession(UserBookstore userBookstore) {
        session = userBookstore;
    }

    @Override
    public UserBookstore currentSession() {
        return session;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Book item: bookCar) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void addBook(Book item) {
        bookCar.add(item);
    }

    @Override
    public void removeBook(int id) {
        Book book = bookCar.stream().filter(item -> item.getId() == id).findFirst().get();
        int index = bookCar.indexOf(book);
        bookCar.remove(index);
    }

    @Override
    public List<Book> getContents() {
        return bookCar;
    }

    @Override
    public void removeSession() {
        session = null;
    }



}
