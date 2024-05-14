import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
import org.testng.reporters.XMLConstants;

public class GetPageTitleTest {

    @Test
    public void getPageTitle(){
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://www.google.co.in");
        System.out.println("Page Title "+page.title());
        page.close();
    }
}
