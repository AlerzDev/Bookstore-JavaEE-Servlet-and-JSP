package servlets.state;



import repositories.CountryRepository;
import repositories.StateRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatePageAdminServlet",urlPatterns = "/StatePageAdmin")
public class StatePageAdminServlet extends HttpServlet {

    @Inject
    private CountryRepository servicesCountry;

    @Inject
    private StateRepository servicesState;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCountry",servicesCountry.getAllItems());
        request.setAttribute("listState",servicesState.getAllItems());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_states.jsp");
        rd.forward(request, response);
    }
}
