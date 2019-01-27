package conferences.controller;


import conferences.dao.entities.Questions;
import conferences.dao.entities.User;
import conferences.dao.repository.DataSource;
import conferences.dao.repository.QuestionRepository;
import conferences.view.QuestionsView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


@WebServlet(name = "QuestionsServlet", urlPatterns = {"/conferences/reports/*"})
public class QuestionsServlet extends HttpServlet {
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
        QuestionRepository questionRepository = new QuestionRepository();
        QuestionsView questionsView = new QuestionsView();

        final int id = Integer.parseInt(request.getParameter("id"));
        if ( request.getParameter("id_question") != null ) {
           int id_question = Integer.parseInt(request.getParameter("id_question"));
            //TODO add to DB rating
           DataSource dataSource = new DataSource();
            try (Connection conn = dataSource.getConnection();
                 Statement stmt = conn.createStatement(); ) {
                    stmt.executeUpdate("UPDATE questions_qs SET ratind_qs=ratind_qs+1 where id_question_qs='" + id_question +"'");
            } catch (
                    SQLException e) {
                e.printStackTrace();
            }
        }
     //   int id_question = Integer.parseInt(request.getParameter("id_question"));

        if ( request.getParameter("writeQuestion") !=null){
            Questions questions_qs = new Questions();
            questions_qs.setQuestion(request.getParameter("writeQuestio"));
            System.out.println("Введене питання = " + request.getParameter("writeQuestion") );
            questions_qs.setAnswer("1");
            questions_qs.setRating(0);
            questions_qs.setId_rp(id);
            questions_qs.setId_usr(user.getId());
            QuestionRepository questionRepository1 = new QuestionRepository();

            questionRepository1.saveQuestion(questions_qs);
            }

            /*   DataSource dataSource = new DataSource();
            try (Connection conn = dataSource.getConnection();
                 Statement stmt = conn.createStatement(); ) {
               // stmt.executeUpdate("UPDATE questions_qs SET ratind_qs=ratind_qs+1 where id_question_qs='" + id_question +"'");
           stmt.execute("insert into questions_qs values ('" + request.getParameter("writeQuestion") + 1 + 1 + id +user.getId()+"')");
               // response.sendRedirect("/conferences/reports/?id_question=" + id_question + "&id=" + id);
            } catch (
                    SQLException e) {
                e.printStackTrace();*/




        List<Questions> question = questionRepository.getQuestionsByIdRp(String.valueOf(id));
        //   List<Questions> question = questionRepository.getQuestionsByIdRp(Long.parseLong(request.getParameter("id")));
        Collections.sort(question, new Comparator<Questions>() {
            @Override
            public int compare(Questions o1, Questions o2) {
                return (String.valueOf(o2.getRating())).compareTo(String.valueOf(o1.getRating()));
            }
        });

       // Collections.reverse(question);

        out.println(questionsView.getHtml(question));



    };






    public void addRating (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        QuestionRepository questionRepository = new QuestionRepository();
        List<Questions> question = questionRepository.getQuestionsByIdRp(String.valueOf(id));


    }


}

