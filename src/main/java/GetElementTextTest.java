import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class GetElementTextTest {

    @Test
    public void getElementText() {

        /*
            1. innerText()
            2. textContent()
            3. innerHTML()
         */

        Playwright playwright=Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://dev.automationtesting.in/text");
        String innerText = page.locator("h5+span").innerText();

        System.out.println("Inner text: "+innerText);

        String textContent = page.locator("h5+span").textContent();

        System.out.println("Text content: "+textContent);

        String innerHTML=page.locator("h5+span").innerHTML();

        System.out.println("Inner html: "+innerHTML);

        playwright.close();



    }
}
