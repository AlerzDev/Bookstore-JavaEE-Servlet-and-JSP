package servlets.typeCard;

import repositories.TypeCardRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TypeCardPageAdminServlet",urlPatterns = "/TypeCardPageAdmin")
public class TypeCardPageAdminServlet extends HttpServlet {

    @Inject
    private TypeCardRepository services;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",services.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_type_card.jsp");
        rd.forward(request, response);
    }
}
