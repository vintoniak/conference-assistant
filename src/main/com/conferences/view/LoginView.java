package conferences.view;

public class LoginView {


    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###content###-->", indexSingleton.getLogin());


    }
}
