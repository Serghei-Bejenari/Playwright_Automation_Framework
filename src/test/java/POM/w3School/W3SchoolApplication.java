package POM.w3School;

import POM.WebBrowser;
import POM.w3School.pages.CodeEditorPage;
import POM.w3School.pages.W3SchoolsHomePage;

public class W3SchoolApplication {
    WebBrowser browser;
    private W3SchoolsHomePage w3SchoolsHomePage;
    private CodeEditorPage codeEditorPage;

    public W3SchoolApplication(WebBrowser browser) {
        this.browser = browser;
    }

    public W3SchoolsHomePage w3SchoolsHomePage() {
        if (w3SchoolsHomePage == null) {
            w3SchoolsHomePage = new W3SchoolsHomePage(browser);
        }
        return w3SchoolsHomePage;
    }

    public CodeEditorPage codeEditorPage() {
        if (codeEditorPage == null) {
            codeEditorPage = new CodeEditorPage(browser);
        }
        return codeEditorPage;
    }

}
