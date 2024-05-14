import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class XpathUnionTest {

    @Test
    public void xpathUnion(){
        Playwright playwright =Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://academy.naveenautomationlabs.com/");

        Locator login =page.locator("//a[text()='Login'] | //a[text()='SignIn']");

        System.out.println("login text"+login.textContent());

        login.click();
        playwright.close();
    }
}
