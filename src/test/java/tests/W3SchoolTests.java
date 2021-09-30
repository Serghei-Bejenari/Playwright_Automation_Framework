package tests;

import POM.WebBrowser;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class W3SchoolTests {
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
    public void changeTabs() {
        browser.w3School().codeEditorPage().open();
        browser.w3School().codeEditorPage().clickW3SchoolLink();
        browser.switchToTab(1);
        Assertions.assertTrue(browser.w3School().w3SchoolsHomePage().isPresent());
        browser.switchToTab(0);
        browser.w3School().codeEditorPage().clickW3SchoolLink();
        browser.switchToTab(2);
        Assertions.assertTrue(browser.w3School().w3SchoolsHomePage().isPresent());
        Assertions.assertEquals(browser.getNumberOfTabs(), 3);
    }
}
