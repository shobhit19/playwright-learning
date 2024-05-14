import com.microsoft.playwright.*;

public class BrowserContextBasics {
    public static void main(String []args){

        Playwright playwright=Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser=playwright.chromium().launch(launchOptions);
        BrowserContext browserContextOne = browser.newContext();

        Page page1 =browserContextOne.newPage();
        page1.navigate("https://www.amazon.co.in");

        BrowserContext browserContextTwo=browser.newContext();
        Page page2 = browserContextTwo.newPage();

        page2.navigate("https://www.google.co.in");

        page1.close();
        page2.close();

        browserContextOne.close();
        browserContextTwo.close();
    }
}
