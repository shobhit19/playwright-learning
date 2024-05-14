import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class JSPopUpHandle {

    @Test
    public void handleJSPopUp(){
        Playwright playwright=Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser=playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();

        page.onDialog(dialog -> {
            String textOnPopUp=dialog.message();
            System.out.println(textOnPopUp);
                dialog.accept("alert alert");
        });

        // JS - alerts, prompt , confirmation
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.click("//button[text()='Click for JS Alert']");

        page.click("//button[text()='Click for JS Confirm']");

        page.click("//button[text()='Click for JS Prompt']");


        page.close();
        browser.close();
        playwright.close();
    }
}
