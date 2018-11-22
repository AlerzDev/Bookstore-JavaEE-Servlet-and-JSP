package servlets.book;

import repositories.BookRepository;
import repositories.FormatRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListBookPageServlet",urlPatterns = "/ListBookPage")
public class ListBookPageServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    @Inject
    private FormatRepository serviceFormat;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int format = Integer.parseInt(request.getParameter("format"));
        request.setAttribute("books",services.getFormatBooks(format));
        request.setAttribute("listFormat", serviceFormat.getAllItems());
        request.setAttribute("namePage",request.getParameter("namePage"));
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/client/client_list_book.jsp");
        rd.forward(request, response);
    }
}
