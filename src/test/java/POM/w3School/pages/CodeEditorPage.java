package POM.w3School.pages;

import POM.BasePage;
import POM.WebBrowser;

public class CodeEditorPage extends BasePage {
    private final String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";
    private final String w3SchoolLink = "a[href='https://www.w3schools.com']";

    public CodeEditorPage(WebBrowser browser) {
        super(browser);
    }

    public void open() {
        browser.page.navigate(url);
    }

    public void clickW3SchoolLink() {
        browser.page.click(w3SchoolLink);
    }
}
