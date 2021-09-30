package POM;

import com.microsoft.playwright.Page;

public class BasePage {

    protected WebBrowser browser;

    public BasePage(WebBrowser browser) {
        this.browser = browser;
    }

    protected boolean isElementPresent(String selector) {
        try {
            browser.page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(1000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
