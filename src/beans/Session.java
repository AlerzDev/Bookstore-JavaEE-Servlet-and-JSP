package beans;

import entities.Book;
import entities.UserBookstore;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Session {
    void initializeSession(UserBookstore userBookstore);
    void addBook(Book item);
    void removeBook(int id);
    List<Book> getContents();
    void removeSession();
    UserBookstore currentSession();
    double getTotal();
}
