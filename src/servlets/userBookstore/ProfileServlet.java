package servlets.userBookstore;


import beans.SessionBean;
import entities.CustomerPaymentCard;
import entities.Sales;
import entities.UserBookstoreCustomerPayment;
import repositories.*;

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

@WebServlet(name = "ProfileServlet",urlPatterns = "/Profile")
public class ProfileServlet extends HttpServlet {

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private BankRepository serviceBank;

    @Inject
    private CompanyCardRepository serviceCompany;

    @Inject
    private TypeCardRepository serviceType;

    @Inject
    private UserBookstoreCustomerPaymentRepository serviceUserCustomer;

    @Inject
    private CustomerPaymentCardRepository serviceCard;

    @Inject
    private SalesRepository serviceSales;

    @Inject
    private BookRepository servicesBook;

    @Inject
    private GenreRepository serviceGenre;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
        List<UserBookstoreCustomerPayment> listRelations = serviceUserCustomer.getItemsByID(session.currentSession().getId());
        List<CustomerPaymentCard> listCards = new ArrayList<>();
        for (UserBookstoreCustomerPayment item: listRelations) {
            listCards.add(serviceCard.getById(item.getCustomerPayment()));
        }
        request.setAttribute("listBook", servicesBook.getAllItems());
        request.setAttribute("listSales", serviceSales.getItemsByID(session.currentSession().getId()));
        request.setAttribute("listCards", listCards);
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        request.setAttribute("listBank", serviceBank.getAll());
        request.setAttribute("listCompany", serviceCompany.getAll());
        request.setAttribute("listType", serviceType.getAll());
        request.setAttribute("listGenre",serviceGenre.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/client/client_profile.jsp");
        rd.forward(request, response);
    }
}
