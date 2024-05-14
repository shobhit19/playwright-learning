import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class ShadowDOMElementTest {


    @Test
    public void interactingWithElementsUnderShadowDOM() throws InterruptedException {
        Page page=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        // Page -- DOM --> Shadow DOM --> elements
        //Page -- DOM --> iFrame --> Shadow DOM --> elements

        page.navigate("https://books-pwakit.appspot.com/");
        Thread.sleep(3000);
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");
        String text=page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println("Text: "+text);

        page.close();
    }
}
