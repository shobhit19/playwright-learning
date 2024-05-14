import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserContextWithMultipleTabScenarios {

    @Test
    public void browserContextWithMultipleTab(){
        Playwright playwright=Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser =playwright.chromium().launch(launchOptions);
        BrowserContext browserContext =browser.newContext();

        Page page1=browserContext.newPage();
        Page page2=browserContext.newPage();

        page1.navigate("https://dev.automationtesting.in");
        page2.navigate("https://demo.automationtesting.in");

        playwright.close();

    }

}
