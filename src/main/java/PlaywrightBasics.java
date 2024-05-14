import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

    public static void main(String []args){
        Playwright playwright=Playwright.create();
        // headles
        //Browser browser =playwright.chromium().launch();
        // without headless
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        // running in chrome
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        // running in edge
        launchOptions.setChannel("msedge");
        launchOptions.setHeadless(false);

        Browser browser = playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");
        System.out.println("Page title "+page.title());
        String url = page.url();
        System.out.println("Page url "+url);

        browser.close();
        playwright.close();



    }
}
