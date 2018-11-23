package servlets.book;

import repositories.BookRepository;
import repositories.FormatRepository;
import repositories.GenreRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookIndexPageServlet",urlPatterns = "/BookIndexPage")
public class BookIndexPageServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private GenreRepository serviceGenre;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listGenre",serviceGenre.getAll());
        request.setAttribute("booksNews",services.getNewBooks());
        request.setAttribute("booksOffers",services.getPopularityBooks());
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
