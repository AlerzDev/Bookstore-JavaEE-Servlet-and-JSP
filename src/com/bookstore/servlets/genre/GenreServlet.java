package com.bookstore.servlets.genre;

import com.bookstore.daos.Genre;
import com.bookstore.models.Response;
import com.bookstore.repositories.GenreRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

@WebServlet(name = "GenreServlet",urlPatterns = "/Genre")
public class GenreServlet extends HttpServlet {

    @Inject
    private GenreRepository services;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response res = new Response();
        try {
            Genre data = gson.fromJson(request.getReader(), Genre.class);
            data.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
            boolean test = services.insert(data);
            res.setSuccess(test);
        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.printStackTrace();
            res.setSuccess(false);
        }
        String employeeJsonString = gson.toJson(res);
        out.print(employeeJsonString);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response data = new Response();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Genre item = services.getById((id));
            if( item != null) {
                data.setSuccess(true);
                data.setItem(gson.toJson(item));
            }else{
                data.setSuccess(false);
            }
        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.printStackTrace();
            data.setSuccess(false);
        }
        String success = gson.toJson(data);
        out.print(success);
        out.flush();
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response data = new Response();
        try {
            data = gson.fromJson(request.getReader(), Response.class);
            data.setSuccess(services.delete(data.getId()));
        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.printStackTrace();
            data.setSuccess(false);
        }
        String employeeJsonString = gson.toJson(data);
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response res = new Response();
        try {
            Genre data = gson.fromJson(request.getReader(), Genre.class);
            data.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
            boolean test = services.updateItem(data);
            res.setSuccess(test);
        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.printStackTrace();
            res.setSuccess(false);
        }
        String employeeJsonString = gson.toJson(res);
        out.print(employeeJsonString);
        out.flush();
    }
}
