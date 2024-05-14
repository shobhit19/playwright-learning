import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class GetPageContentTest {

    @Test
    public void getPageContentTest(){
        Playwright playwright=Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        page.navigate("https://www.google.co.in");
        String content=page.content();

        System.out.println("Content of the page "+content);

    }
}
