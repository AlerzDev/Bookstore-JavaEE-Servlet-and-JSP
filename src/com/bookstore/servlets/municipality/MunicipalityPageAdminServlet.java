package com.bookstore.servlets.municipality;

import com.bookstore.repositories.MunicipalityRepository;
import com.bookstore.repositories.StateRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MunicipalityPageAdminServlet",urlPatterns = "/MunicipalityPageAdmin")
public class MunicipalityPageAdminServlet extends HttpServlet {

    @Inject
    private StateRepository servicesState;

    @Inject
    private MunicipalityRepository servicesMunicipality;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listState",servicesState.getAll());
        request.setAttribute("listMunicipality",servicesMunicipality.getAll());
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/admin/admin_municipalities.jsp");
        rd.forward(request, response);
    }
}
