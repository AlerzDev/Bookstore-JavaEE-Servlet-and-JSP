package servlets.book;

import beans.SessionBean;
import entities.CustomerPaymentCard;
import entities.UserBookstoreCustomerPayment;
import repositories.CustomerPaymentCardRepository;
import repositories.FormatRepository;
import repositories.UserBookstoreCustomerPaymentRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCarPageServlet",urlPatterns = "/ShoppingCarPage")
public class ShoppingCarPageServlet extends HttpServlet {

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private UserBookstoreCustomerPaymentRepository serviceUserCustomer;

    @Inject
    private CustomerPaymentCardRepository serviceCard;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
        List<UserBookstoreCustomerPayment> listRelations = serviceUserCustomer.getItemsByID(session.currentSession().getId());
        List<CustomerPaymentCard> listCards = new ArrayList<>();
        for (UserBookstoreCustomerPayment item: listRelations) {
            listCards.add(serviceCard.getById(item.getCustomerPayment()));
        }
        request.setAttribute("listCards", listCards);
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/client/client_list_car.jsp");
        rd.forward(request, response);
    }
}
