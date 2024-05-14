import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class AutomaticLoginTest {

    @Test
    public void automaticLogin(){
        Playwright playwright=Playwright.create();

        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext =browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://tnp2-web01.test.dom:5175/login");
        page.fill("//input[@formcontrolname='username']","test.obi");
        page.fill("//input[@formcontrolname='password']","dHdMx2Ut");

        page.click("//button[@type='submit']");

        System.out.println(page.title());
        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("screenshots/userlogin.json")));
        playwright.close();
    }

    @Test
    public void loginAgainUsingJsonFile(){
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

         BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("screenshots/userlogin.json")));

         Page page = browserContext.newPage();
         page.navigate("https://tnp2-web01.test.dom:5175/login");
    }
}
