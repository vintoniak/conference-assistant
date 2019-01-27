package conferences.controller;

import conferences.dao.entities.Conferences;
import conferences.dao.entities.Reports;
import conferences.dao.entities.User;
import conferences.dao.repository.ConferenceRepository;
import conferences.dao.repository.ReportsRepository;
import conferences.view.ConferencesView;
import conferences.view.ReportsView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ReportsServlet", urlPatterns = {"/conferences/edit", "/conferences/edit/"}, loadOnStartup = 5)
public class ReportsServlet extends HttpServlet {
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
        ReportsRepository reportsRepository = new ReportsRepository();

       ReportsView reportsView = new ReportsView();

     List<Reports> reports = reportsRepository.getReportsByIdCf(Long.parseLong(request.getParameter("id")));
out.println(reportsView.getHtml(reports));


        switch (request.getPathInfo())

        {
            case "/logout/":
                session.setAttribute("user", null);
                response.sendRedirect("/main");
                break;
        }


    }
}
