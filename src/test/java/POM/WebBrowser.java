package POM;

import POM.swagLabs.SwagLabsApplication;
import POM.w3School.W3SchoolApplication;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class WebBrowser {

    Browser browser;
    Playwright playwright;
    public Page page;
    BrowserContext context;
    private SwagLabsApplication swagLabs;
    private W3SchoolApplication w3School;

    public WebBrowser() {
        browser = getBrowser();
        context = browser.newContext();
        getVideo();
        getThread();
        page = context.newPage();
    }

    public Browser getBrowser() {
        String browserName = System.getProperty("browser", "chrome");
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.
                        LaunchOptions().setHeadless(false).setSlowMo(3000));
            case "firefox":
                return playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            default:
                throw new RuntimeException("ATF is not configured for " + browserName);
        }
    }

    public W3SchoolApplication w3School() {
        if (w3School == null) {
            w3School = new W3SchoolApplication(this);
        }
        return w3School;
    }

    public SwagLabsApplication swagLabs() {
        if (swagLabs == null) {
            swagLabs = new SwagLabsApplication(this);
        }
        return swagLabs;
    }

    public void close() {
        playwright.close();
    }

    public int getNumberOfTabs() {
        return context.pages().size();
    }

    public void switchToTab(int index) {
        page = context.pages().get(index);
    }

    public void getVideo() {
        context = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("target/videos/"))
                        .setRecordVideoSize(840, 480));
    }

    public void getThread() {
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));
    }

    public void stopThread(String title) {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("target/trace" + "_" + title.replaceAll(" ", "_") + ".zip")));
    }
}
