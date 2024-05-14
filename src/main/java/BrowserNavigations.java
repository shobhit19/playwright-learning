import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.Assert;

public class BrowserNavigations {


    /**
     *  Test Scenario
     *  Navigate to the Internet Herokuapp demo website
     *  Click on the Challenging DOM link to navigate to its respective page
     *  Check that the page header of Challenging DOM page is displayed as “Challenging DOM”
     *  Perform the back navigation on the browser, it should take user back to the home page
     *  of the website. On the home page,check that the page header is displayed as
     *  “Available Examples”.
     *  Perform the forward navigation on the browser, it should again take the user to the
     *  “Challenging DOM” where the page header should be displayed as “Challenging DOM”.
     *  Get the current page’s Url.
     *
     */

    public static void main(String []args){
        browserNavigations();
    }

    private static void browserNavigations(){

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page=browser.newPage();

        page.navigate("https://the-internet.herokuapp.com/");
        String homePageHeader = page.locator("h2").textContent();
        Assert.assertEquals(homePageHeader,"Available Examples");
        page.locator("//a[text()='Challenging DOM']").click();
        Assert.assertEquals(page.locator("h3").textContent(),"Challenging DOM");

        page.goBack();
        Assert.assertEquals(page.locator("h2").textContent(),"Available Examples");

        page.goForward();
        Assert.assertEquals(page.locator("h3").textContent(),"Challenging DOM");
        System.out.println(page.url());


        /**
         *  There are overloaded methods also based on waiting conditions
         */
//
//        page.goBack(new Page.GoBackOptions().setTimeout(10));
//        page.goForward(new Page.GoForwardOptions().setTimeout(10));
//
//        page.goBack(new Page.GoBackOptions().setWaitUntil(WaitUntilState.LOAD));

        page.close();
        playwright.close();


    }
}
