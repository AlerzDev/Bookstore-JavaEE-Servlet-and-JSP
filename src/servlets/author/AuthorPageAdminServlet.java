package servlets.author;



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

@WebServlet(name = "AuthorPageAdminServlet",urlPatterns = "/AuthorPageAdmin")
public class AuthorPageAdminServlet extends HttpServlet {

    @Inject
    private CountryRepository servicesCountry;
    @Inject
    private StateRepository servicesState;
    @Inject
    private MunicipalityRepository servicesMunicipality;
    @Inject
    private StatusRepository servicesStatus;
    @Inject
    private AuthorRepository servicesAuthor;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCountry", servicesCountry.getAllItems());
        request.setAttribute("listState", servicesState.getAllItems());
        request.setAttribute("listMunicipality", servicesMunicipality.getAllItems());
        request.setAttribute("listStatus", servicesStatus.getAllItems());
        request.setAttribute("listAuthor", servicesAuthor.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_author.jsp");
        rd.forward(request, response);
    }
}
