package com.bookstore.servlets.book;

import com.bookstore.repositories.BookRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookPageServlet",urlPatterns = "/BookPageAdmin")
public class BookPageServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",services.GetBooksActive());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_books.jsp");
        rd.forward(request, response);
    }
}
