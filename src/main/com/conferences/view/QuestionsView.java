package conferences.view;

import conferences.controller.QuestionsServlet;
import conferences.dao.entities.Questions;
import conferences.dao.entities.Reports;
import conferences.dao.repository.ReportsRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsView {


    public String getHtml (List<Questions> questions) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###content###-->", indexSingleton.getQuestions());

        String allQuestions = questions.stream().map(n -> {
            String text = "";
            return
                    // class=\"conferences-short-view\" href=\"reports/edit?id=" +
                    //                         n.getId() +
                 "<h4>" +    n.getQuestion()  +
                         "<a  class=\"btn btn-default\" href=\"/conferences/reports/?id_question=" + n.getId() +
                         "&id=" + n.getId_rp() + "\">" +
                "<img src=\"/images/like.png\" alt=\"\" style=\"vertical-align:left\">" +
                            n.getRating() +
                "</button> </a>" +
                         "</h4>";

        }).collect(Collectors.joining(" "));

        String textarea = "<div class=\"mb-3\">\n" +
                " \n" +
                "         <form >\n" +
                "     <div class=\"input-group input-group-lg\">\n" +
                "     <input  type=\"text\" name=\"writeQuestion\" class=\"form-control\" placeholder=\"Type your question here..\" aria-label=\"Type your question here..\" aria-describedby=\"AddQuestion\">\n" +
                "     </div >\n" +
                "         <div  class=\"input-group-append\">\n " +
                "        <a class=\"btn btn-default\" " +
                "href=\"/conferences/reports/?id_question=" +
                  questions.get(0).getId() +
                "&id=" + questions.get(0).getId_rp()+
                "\" > <button  class=\"btn btn-outline-secondary\" type=\"button\" id=\"AddQuestion\">Add Question</button>\n" +
                "      </a>  " +
                "</div>\n" +
                " \n" +
                "     </form>\n" +
                "     </div >";

        return page
                .replace("<!--###-add-questions-###-->", allQuestions)
                .replace("<!--###-textarea-###-->", textarea);

    }





}
