package conferences.controller;

import conferences.dao.entities.User;
import conferences.dao.repository.UserRepository;
import conferences.formValidator.RegisterFormValidator;
import conferences.view.ConferencesView;
import conferences.view.IndexSingleton;
import conferences.view.LoginView;
import conferences.view.RegisterView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",  urlPatterns = {"/register/", "/register"}, loadOnStartup = 3)
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        RegisterView registerView = new RegisterView();
        out.println(registerView.getHtml());


        HttpSession session = request.getSession();

        if (request.getParameter("email") != null) {
            request.getParameter("password");
        }

        if (request.getParameter("email") != null) {
            RegisterFormValidator registerFormVallidator =
                    new RegisterFormValidator(
                            request.getParameter("nickname"),
                            request.getParameter("email"),
                            request.getParameter("password")
                            );

            if (!registerFormVallidator.isFormValid()) {
                out.println(registerFormVallidator.getMessageError());
            } else {
                UserRepository userRepository = new UserRepository();
                User user = new User();
                user.setNickName(request.getParameter("nickname"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                if(request.getParameter("role") == null) {
                    user.setRole(3);
                } else {
                    // Запис із адміністративної частини ЗВЕРНУТИ УВАГУ!!!
                    user.setRole(request.getIntHeader("role"));
                }

                if(userRepository.UserExist(request.getParameter("nickname"),
                        request.getParameter("email") ) == null ){
                    userRepository.saveUser(user);
                    response.sendRedirect("http://localhost:8080/login");
                    //LoginView loginView = new LoginView();
                  //  out.println(loginView.getHtml());
                } else out.println("User with the same nickname or email exist");


            }

            /* switch (request.getPathInfo()) {

                case "/register/":
                case "/register":
                    response.sendRedirect("/login");

                    break;
                case "/logout/":
                    session.setAttribute("user", null);
                    response.sendRedirect("/main");
                    break;
                default:
                    out.println("<html><head><title>MyServlet</title></head><body>");
                    out.write("<H1>Hello Servlet World! User!</H1>");
                    out.write("URI   \t" + request.getPathInfo());
                    out.println("</body>");
                    out.println("</html>");
            }

            User user = (User) session.getAttribute("user");
            if (user == null) {
                out.println("Please, log in again");
            } else {
                session.setAttribute("user",user);
                response.sendRedirect("/conferences");
            } */


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
