package conferences.view;

import conferences.dao.entities.Reports;

import java.util.List;
import java.util.stream.Collectors;

public class ReportsView {

    public String getHtml (List<Reports> reports) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###content###-->", indexSingleton.getReports());


        String allReports = reports.stream().map(n -> {
            String text = "";
            return "<a class=\"conferences-short-view\" href=\"reports/edit?id=" +
                         n.getId() +  "\">" +
                       //  "<div class=\"col-6 col-sm-4 col-md-3\"  >\n" +
                         " <p> <h3>" + n.getName() + "</h3> </p>\n" +
                       "</a> <br> ";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-reports-###-->", allReports);



    }
}
// "" + "?name=" + n.getName() +