package conferences.view;

import conferences.dao.entities.Conferences;

import java.util.List;

import java.util.stream.Collectors;

public class ConferencesView {

    public String getHtml(List<Conferences> conferences) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
       String page = indexSingleton.getPage()
               .replace("<!--###content###-->", indexSingleton.getConferences());

       String allConferences = conferences.stream().map(n -> {
           String text = "";
         return "<a class=\"conferences-short-view\" href=\"/conferences/edit?id=" +
                 n.getId() + "\">" +
                // "<div class=\"col-6 col-sm-4 col-md-3\"  >\n" +
                // "<li class=\" list-group-item active\">" + n.getName() + "</li>\n" +
                   "<p> <h3>" + n.getName() + "</h3> </p>\n" +
                 //  "</div>\n" +
                   "</a> <br>";
       }).collect(Collectors.joining(" "));


       return page.replace("<!--###-add-conferences-###-->", allConferences);


    }



}

