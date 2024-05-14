import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingDropDownTest {



    @Test
    public void handleDropDown() throws InterruptedException {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser = playwright.chromium().launch(launchOptions);
        Page page=browser.newPage();

        page.navigate("https://dev.automationtesting.in/form");
        // way1
        page.selectOption("//select[@id='day-select']","10");
        Thread.sleep(5000);
        // way2
        page.locator("//select[@id='day-select']").selectOption("20");
        // way 3
        page.locator("//select[@id='day-select']").selectOption(new SelectOption().setValue("10"));

        // way 4
        page.navigate("https://www.lambdatest.com/selenium-playground/");
        page.locator("//a[text()='Select Dropdown List']").click();
        Locator dropDown = page.locator("#multi-select");
                dropDown.selectOption(new SelectOption[]{new SelectOption().setLabel("New York"), new SelectOption().setLabel("Texas"), new SelectOption().setValue("California"),
        new SelectOption().setIndex(7)});



        playwright.close();
    }
}
