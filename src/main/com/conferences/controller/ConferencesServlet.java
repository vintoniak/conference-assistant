package conferences.controller;

import conferences.dao.entities.Conferences;
import conferences.dao.entities.User;
import conferences.dao.repository.ConferenceRepository;
import conferences.view.ConferencesView;
import conferences.view.IndexSingleton;
import conferences.view.MainView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConferencesServlet", urlPatterns = {"/conferences", "/conferences/"}, loadOnStartup = 4)
public class ConferencesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            out.println("Please, log in ");
            response.sendRedirect("/main");
            return;
        }

        ConferencesView conferencesView = new ConferencesView();

        ConferenceRepository conferenceRepository = new ConferenceRepository();


        out.println(conferencesView.getHtml((conferenceRepository.getConferences())));


        switch (request.getPathInfo())

        {
            case "/logout/":
                session.setAttribute("user", null);
                response.sendRedirect("/main");
                break;
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
