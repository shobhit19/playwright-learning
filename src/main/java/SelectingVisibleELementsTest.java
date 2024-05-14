import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.List;

public class SelectingVisibleELementsTest {

    @Test
    public void getVisibleLinksElementsText(){
        Playwright playwright =Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://amazon.com/");
        List<String> linksText =page.locator("a:visible").allInnerTexts();

        for(int i=0;i<linksText.size();i++){
            System.out.println(linksText.get(i));
        }
        playwright.close();
    }

    @Test
    public void getImageVisibleOnThePage(){
        Playwright playwright =Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://amazon.com/");
        int imagesCount = page.locator("//img >> visible=true").count();
        System.out.println(imagesCount);

        playwright.close();

    }
}
