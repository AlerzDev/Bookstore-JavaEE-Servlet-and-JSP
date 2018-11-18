package com.bookstore.servlets.status;

import com.bookstore.repositories.StatusRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatusPageAdminServlet",urlPatterns = "/StatusPageAdmin")
public class StatusPageAdminServlet extends HttpServlet {

    @Inject
    private StatusRepository services;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",services.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_status.jsp");
        rd.forward(request, response);
    }
}
