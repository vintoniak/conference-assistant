package conferences.controller;

import conferences.dao.entities.User;
import conferences.dao.repository.UserRepository;
import conferences.formValidator.RegisterFormValidator;
import conferences.view.IndexSingleton;
import conferences.view.LoginView;
import conferences.view.MainView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login/", "/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        LoginView loginView = new LoginView();
        out.println(loginView.getHtml());

        HttpSession session = request.getSession();

        if (request.getParameter("email") !=null){
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailByPassword
                    (request.getParameter("email"), request.getParameter("password"));

            if (user == null) {
                out.println("Please, log in again");
            } else {
                session.setAttribute("user",user);
                response.sendRedirect("/conferences");
            }
        }
    }




    @Override
    public void init() throws ServletException {
        super.init();
        //set path
        String path = getServletContext().getRealPath("/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setHtmlPath(path);
    }
}
