package servlets.userBookstore;

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
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


@WebServlet(name = "SendEmailServlet",urlPatterns = "/SendEmail")
public class SendEmailServlet extends HttpServlet {

    @Inject
    private BookRepository services;

    @Inject
    private FormatRepository serviceFormat;

    @Inject
    private GenreRepository serviceGenre;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String msg = request.getParameter("msg");

        final String username = "alerz12@gmail.com";
        final String password = "Hola1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("alex.lemus.dev@gmail.com"));
            message.setSubject("Mensaje de cliente:" + name);
            message.setText(msg);

            Transport.send(message);

            request.setAttribute("listGenre",serviceGenre.getAll());
            request.setAttribute("booksNews",services.getNewBooks());
            request.setAttribute("booksOffers",services.getPopularityBooks());
            request.setAttribute("listFormat", serviceFormat.getAllItems());
            ServletContext context= getServletContext();
            RequestDispatcher rd= context.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
