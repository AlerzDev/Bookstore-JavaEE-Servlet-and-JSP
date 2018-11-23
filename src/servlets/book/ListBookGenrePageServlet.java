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

@WebServlet(name = "ListBookGenrePageServlet", urlPatterns = "/ListBookGenrePage")
public class ListBookGenrePageServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private GenreRepository serviceGenre;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int genre = Integer.parseInt(request.getParameter("genre"));
        request.setAttribute("listGenre",serviceGenre.getAll());
        request.setAttribute("books",services.getGenreBooks(genre));
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        request.setAttribute("namePage",request.getParameter("namePage"));
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/client/client_list_book.jsp");
        rd.forward(request, response);
    }
}
