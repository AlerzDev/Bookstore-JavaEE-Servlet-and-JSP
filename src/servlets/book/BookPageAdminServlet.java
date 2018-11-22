package servlets.book;



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

@WebServlet(name = "BookPageAdminServlet",urlPatterns = "/BookPageAdmin")
public class BookPageAdminServlet extends HttpServlet {

    @Inject
    private BookRepository services;
    @Inject
    private AuthorRepository servicesAuthor;
    @Inject
    private StatusRepository servicesStatus;
    @Inject
    private FormatRepository servicesFormat;
    @Inject
    private GenreRepository servicesGenre;
    @Inject
    private EditorialRepository servicesEditorial;
    @Inject
    private LanguageRepository servicesLanguage;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",services.getAllItems());
        request.setAttribute("listAuthor",servicesAuthor.getAll());
        request.setAttribute("listGenre",servicesGenre.getAll());
        request.setAttribute("listFormat",servicesFormat.getAllItems());
        request.setAttribute("listLanguage",servicesLanguage.getAll());
        request.setAttribute("listStatus",servicesStatus.getAllItems());
        request.setAttribute("listEditorial",servicesEditorial.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_books.jsp");
        rd.forward(request, response);
    }
}
