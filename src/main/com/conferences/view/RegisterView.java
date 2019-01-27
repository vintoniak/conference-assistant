package conferences.view;

public class RegisterView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###content###-->", indexSingleton.getRegister());


    }

}
