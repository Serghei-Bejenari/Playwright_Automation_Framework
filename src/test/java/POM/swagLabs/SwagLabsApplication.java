package POM.swagLabs;

import POM.WebBrowser;
import POM.swagLabs.pages.HomePage;
import POM.swagLabs.pages.LogInPage;

public class SwagLabsApplication {
    WebBrowser browser;
    private LogInPage logInPage;
    private HomePage homePage;

    public SwagLabsApplication(WebBrowser browser) {
        this.browser = browser;
    }

    public LogInPage logInPage() {
        if (logInPage == null) {
            logInPage = new LogInPage(browser);
        }
        return logInPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(browser);
        }
        return homePage;
    }
}
