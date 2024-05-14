import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaptureFullPageScreenshot {


    @Test
    public void getFullPageScreenshot(){
        Playwright playwright = Playwright.create();
        Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        page.navigate("https://playwright.dev/java/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/fullPage.png")).setFullPage(true));

        playwright.close();


    }
}
