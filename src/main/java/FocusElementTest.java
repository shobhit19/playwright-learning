import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FocusElementTest {

    @Test
    public void setFocusToElement() throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser =playwright.chromium().launch(launchOptions);
        Page page =browser.newPage();

        page.navigate("https://dev.automationtesting.in/form");
        // way 1
        page.focus("text = Address");
        Thread.sleep(3000);

        // way 2
        page.locator("//input[@name='lastName']").focus();

        playwright.close();
    }
}
