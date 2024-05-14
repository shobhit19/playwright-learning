import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingButtons {

    @Test
    public void handleButtons(){
        Playwright playwright = Playwright.create();
        Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")).newPage();

        page.navigate("https://dev.automationtesting.in");

        // way 1
        page.click("//button[text()='SKIP LOGIN']");

        // way 2 (recomended)
        page.locator("//button[text()='SKIP LOGIN']").click();

        playwright.close();
    }
}
