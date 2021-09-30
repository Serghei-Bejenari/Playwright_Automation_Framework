package POM.swagLabs.pages;

import POM.BasePage;
import POM.WebBrowser;

public class LogInPage extends BasePage {
    private final String userNameField = "#user-name";
    private final String passwordField = "#password";
    private final String loginButton = "#login-button";
    private final String url = "https://www.saucedemo.com/";

    public LogInPage(WebBrowser browser) {
        super(browser);
    }

    public void open() {
        browser.page.navigate(url);
    }

    public void logIn(String userName, String password) {
        browser.page.fill(userNameField, userName);
        browser.page.fill(passwordField, password);
        browser.page.click(loginButton);
    }

    public boolean isPresent() {
        return isElementPresent(userNameField) && isElementPresent(passwordField) && isElementPresent(loginButton);
    }
}
