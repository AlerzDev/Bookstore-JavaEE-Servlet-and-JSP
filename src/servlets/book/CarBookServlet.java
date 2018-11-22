package servlets.book;

import beans.SessionBean;
import entities.Book;
import entities.Sales;
import repositories.BookRepository;
import repositories.SalesRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CarBookServlet",urlPatterns = "/CarBook")
public class CarBookServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    @Inject
    private SalesRepository servicesSale;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
        int id = Integer.parseInt(request.getParameter("idBook"));
        Book book = services.getItemById(id);
        session.addBook(book);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
        int id = Integer.parseInt(request.getParameter("idBook"));
        session.removeBook(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        int idCardMethod = Integer.parseInt(req.getParameter("cardMethod"));
        SessionBean session = (SessionBean) req.getSession().getAttribute("currentSession");
        Iterator<Book> books = session.getContents().iterator();
        while (books.hasNext()) {
            Book item = books.next();
            if(item.getStock() > 0){
                Sales sales = new Sales();
                sales.setBook(item.getId());
                sales.setUserBookstore(idUser);
                sales.setCustomerPayment(idCardMethod);
                sales.setOldStock(item.getStock());
                sales.setNewStock(item.getStock()-1);
                sales.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
                item.setStock(item.getStock()-1);
                if(servicesSale.insert(sales) && services.updateItem(item)){
                    books.remove();
                }
            }
        }
    }
}
