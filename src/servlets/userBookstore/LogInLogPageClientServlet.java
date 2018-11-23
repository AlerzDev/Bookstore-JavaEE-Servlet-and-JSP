package servlets.userBookstore;

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

@WebServlet(name = "LogInLogPageClientServlet",urlPatterns = "/LogInLogPageClient")
public class LogInLogPageClientServlet extends HttpServlet {

    @Inject
    private CountryRepository servicesCountry;

    @Inject
    private MunicipalityRepository servicesMunicipality;

    @Inject
    private StateRepository servicesState;

    @Inject
    private StatusRepository servicesStatus;

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private GenreRepository serviceGenre;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCountry", servicesCountry.getAllItems());
        request.setAttribute("listState", servicesState.getAllItems());
        request.setAttribute("listMunicipality", servicesMunicipality.getAllItems());
        request.setAttribute("listStatus", servicesStatus.getAllItems());
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        request.setAttribute("listGenre",serviceGenre.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/client/client_login_logout.jsp");
        rd.forward(request, response);
    }

}
