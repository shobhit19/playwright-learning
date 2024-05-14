import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

    public static void main(String[] args) {


       Playwright playwright= Playwright.create();
       Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

       Page page=browser.newPage();
//       page.navigate("https://www.orangehrm.com/");
//       page.locator("text=Contact Sales").first().click();


        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        //String header = page.locator("h2:has-text('New Customer')").textContent();
        // Or below
        String header = page.locator("div.well h2:has-text('New Customer')").textContent();

        System.out.println(header);

        // We can also omit "text=" from the locator but we have to use single quote ''
        String alternativeApproach = page.locator("'Returning Customer'").textContent();
        System.out.print(alternativeApproach);


        // button


        browser.close();
        playwright.close();
    }
}
