package servlets.book;

import repositories.BookRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ImageServlet",urlPatterns = "/GetImage")
public class ImageServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        String[] elements = queryString.split("=");
        int idBook = Integer.parseInt(elements[1]);
        byte[] bytes = services.getArrayImage(idBook);
        response.setContentType("image/gif");
        OutputStream out = response.getOutputStream();
        out.write(bytes);
    }
}
