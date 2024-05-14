import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.List;

public class ScopeLocatorsTest {


        @Test
        public void selectCheckBoxAgainstARecord() throws InterruptedException {
            Playwright playwright = Playwright.create();
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

            page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

            Locator row = page.locator("//table[@id='example']/tbody/tr");
            Thread.sleep(3000);
            row.locator(":scope", new Locator.LocatorOptions()
                            .setHasText("Ashton Cox")).
                    locator(".select-checkbox")
                    .click();

            playwright.close();
        }

        @Test
        public void getAllTextOfRows(){
            Playwright playwright = Playwright.create();
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

            page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

            Locator row = page.locator("//table[@id='example']/tbody/tr");

            List<String> listOfData =row.locator(":scope").allInnerTexts();

            for(int i=0;i<listOfData.size();i++) {

                System.out.println(" Row No." + i + listOfData.get(i));
            }
        }

}
