import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingRadioButtons {

    @Test
    public void handleRadioButtons(){
        Playwright playwright = Playwright.create();
        Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")).newPage();

        page.navigate("https://dev.automationtesting.in/form");

        //way 1
        page.check("//input[@value='Female']");

        // way 2
        page.locator("//input[@value='Male']").check();

        // way 3
        page.locator("//input[@value='Other']").click();

        playwright.close();

    }
}
