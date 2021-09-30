package POM.w3School.pages;

import POM.BasePage;
import POM.WebBrowser;

public class W3SchoolsHomePage extends BasePage {
    private final String loginBtn = "#w3loginbtn";

    public W3SchoolsHomePage(WebBrowser browser) {
        super(browser);
    }

    public boolean isPresent() {
        return isElementPresent(loginBtn);
    }
}
