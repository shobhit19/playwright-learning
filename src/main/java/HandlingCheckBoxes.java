import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingCheckBoxes {

    @Test
    public void handleCheckBoxes(){

        Playwright playwright=Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/form");


        // check() method clicks the check box and uncheck() method unchecks the check box
        page.check("//input[@value='automation_testing']");
        page.uncheck("//input[@value='automation_testing']");

        // to check if any check box is not selected then check it
        if(!page.locator("//input[@value='development']").isChecked()){
            page.click("//input[@value='development']");
        }
        page.locator("//input[@value='management']").click();

    }
}
