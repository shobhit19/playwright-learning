import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class CaptureElementScreenshotTest {

    @Test
    public void elementScreenShotTest(){

        Playwright playwright = Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")).newPage();
        page.navigate("https://dev.automationtesting.in/");

        page.locator("//input[@name='email']")
                    .screenshot(new Locator.ScreenshotOptions()
                        .setPath(Paths.get("screenshots/emailField.png")));

        playwright.close();

;    }
}
