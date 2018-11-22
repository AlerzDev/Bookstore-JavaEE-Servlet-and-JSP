package servlets.userBookstore;

import bases.ServletBase;
import beans.SessionBean;
import entities.UserBookstore;
import repositories.UserBookstoreRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SessionUserBookstoreServlet",urlPatterns = "/SessionUserBookstore")
public class SessionUserBookstoreServlet extends ServletBase {

    @Inject
    private UserBookstoreRepository services;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        try {
            UserBookstore item = gson.fromJson(request.getReader(), UserBookstore.class);
            item = services.getUser(item.getUsername(),item.getPassword());
            if(item != null){
                data.setSuccess(true);
                SessionBean session = (SessionBean) request.getSession().getAttribute("currentSession");
                session.initializeSession(item);
            }else{
                data.setSuccess(false);
            }
        }catch (Exception ex) {
            data.setSuccess(false);
            ex.printStackTrace();
        }
        out.print(gson.toJson(data));
        out.flush();
    }
}
