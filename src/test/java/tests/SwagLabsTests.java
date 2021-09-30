package tests;

import POM.WebBrowser;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SwagLabsTests {

    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    WebBrowser browser;

    @BeforeAll
    void launchBrowser() {
        browser = new WebBrowser();
    }

    @AfterAll
    void closeBrowser() {
        browser.stopThread(browser.page.title());
        browser.close();
    }

    @Test
    public void logInTest() {
        browser.swagLabs().logInPage().open();
        browser.swagLabs().logInPage().logIn(userName, password);
        Assertions.assertTrue(browser.swagLabs().homePage().isPresent());
    }

    @Test
    public void logOutTest() {
        browser.swagLabs().logInPage().open();
        browser.swagLabs().logInPage().logIn(userName, password);
        browser.swagLabs().homePage().logOut();
        Assertions.assertTrue(browser.swagLabs().logInPage().isPresent());
    }
}
