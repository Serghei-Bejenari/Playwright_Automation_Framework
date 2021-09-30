package POM.swagLabs.pages;

import POM.BasePage;
import POM.WebBrowser;

public class HomePage extends BasePage {

    private final String burgerMenu = "#react-burger-menu-btn";
    private final String logOutButton = "#logout_sidebar_link";
    private final String url = "https://www.saucedemo.com/inventory.html";

    public HomePage(WebBrowser browser) {
        super(browser);
    }

    public void logOut() {
        browser.page.click(burgerMenu);
        browser.page.click(logOutButton);
    }

    public boolean isPresent() {
        return isElementPresent(burgerMenu);
    }
}
