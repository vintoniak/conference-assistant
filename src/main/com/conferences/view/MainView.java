package conferences.view;

public class MainView {




        public String getHtml() {
            IndexSingleton indexSingleton = IndexSingleton.getInstance();
            return indexSingleton.getPage()
                    .replace("<!--###header###-->", indexSingleton.getHeader());


    }
}
