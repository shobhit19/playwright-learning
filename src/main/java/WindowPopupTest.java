import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class WindowPopupTest {


    @Test
    public void handleMultipleTabsNavigationFromOneApplicationToAnotherAfterClickingOnLinkPresent(){
        // open a new tab/window/pop up after clicking on link on parent page
        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context1 =browser.newContext();
//        BrowserContext context2=browser.newContext();

        Page page=context1.newPage();
//        Page page2 = context2.newPage();

        page.navigate("https://www.orangehrm.com/");

        Page popUp=page.waitForPopup(()->{
            page.click("//img[@alt='linkedin logo']");
        });

        System.out.println("pop up window Linked page "+popUp.url());
        popUp.close();
        System.out.println("parent window title "+page.title());
        page.close();
    }

     @Test
     public void handleMultipleTabsNavigationFromOneApplicationOpenBlankPageAndOpenNewUrl(){

        // open a new blank tab/window/pop up and enter the new url
        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context1 =browser.newContext();

        Page page = context1.newPage();
        page.navigate("https://www.amazon.co.in");
        Page popUp=page.waitForPopup(() ->{
            page.click("a[target='_blank']"); // opens a blank new tab window
        });
        popUp.waitForLoadState();
        popUp.navigate("https://www.google.co.in");
        System.out.println("Pop up window title "+popUp.title());
        popUp.close();
        System.out.println("Parent window title "+page.title());
        page.close();
    }
}
