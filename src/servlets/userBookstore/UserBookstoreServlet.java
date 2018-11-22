package servlets.userBookstore;

import bases.ServletBase;
import com.google.gson.JsonSyntaxException;
import entities.UserBookstore;
import models.Response;
import repositories.UserBookstoreRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@WebServlet(name = "UserBookstoreServlet", urlPatterns = "/UserBookStore")
public class UserBookstoreServlet extends ServletBase {

    @Inject
    private UserBookstoreRepository services;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        try {
            UserBookstore item = gson.fromJson(request.getReader(), UserBookstore.class);
            item.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
            item.setStatus(151);
            data.setSuccess(services.insertItem(item));
        }catch (IllegalStateException | JsonSyntaxException exception){
            data.setSuccess(false);
            exception.printStackTrace();
        }
        String employeeJsonString = gson.toJson(data);
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserBookstore item = services.getItemById((id));
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
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
        try {
            UserBookstore item = gson.fromJson(request.getReader(), UserBookstore.class);
            item.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
            data.setSuccess(services.updateItem(item));
        }catch (IllegalStateException | JsonSyntaxException exception){
            data.setSuccess(false);
            exception.printStackTrace();
        }
        String employeeJsonString = gson.toJson(data);
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        try {
            data = gson.fromJson(request.getReader(), Response.class);
            data.setSuccess(services.deleteItem(data.getId()));
        }catch (IllegalStateException | JsonSyntaxException exception){
            exception.printStackTrace();
            data.setSuccess(false);
        }
        String employeeJsonString = gson.toJson(data);
        out.print(employeeJsonString);
        out.flush();
    }

}
