package servlets.payment;

import beans.SessionBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import entities.CustomerPaymentCard;
import entities.UserBookstoreCustomerPayment;
import models.Response;
import repositories.CustomerPaymentCardRepository;
import repositories.UserBookstoreCustomerPaymentRepository;

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

@WebServlet(name = "PaymentServlet",urlPatterns = "/Payment")
public class PaymentServlet extends HttpServlet {


    @Inject
    private CustomerPaymentCardRepository services;

    @Inject
    private UserBookstoreCustomerPaymentRepository servicesuser;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response res = new Response();
        try {
            SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
            CustomerPaymentCard data = gson.fromJson(request.getReader(), CustomerPaymentCard.class);
            data.setRegDate(new Date(Calendar.getInstance().getTime().getTime()));
            long id = services.insertItem(data);
            long idUser = session.currentSession().getId();
            UserBookstoreCustomerPayment payment = new UserBookstoreCustomerPayment();
            payment.setCustomerPayment(id);
            payment.setUserBookstore(idUser);
            boolean test = servicesuser.insert(payment);
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

    }

}
