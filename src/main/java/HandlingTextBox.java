import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingTextBox {

    /**
     * 1. using type() method
     * 2. using fill() method
     */


    @Test
    public void handlingTextBoxUsingTypeMethod(){
        Playwright playwright = Playwright.create();
        Page page =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")).newPage();

        page.navigate("https://dev.automationtesting.in/form");
        // type() 1st method
        page.locator("//input[@name='firstName']").type("test");
        // type() overloaded 2nd method
        page.type("//input[@name='lastName']","test");
        // type() overloaded 3rd method - in this user can enter the text in text field slowly or set delay
        // as per need
        page.type("//textarea[@name='address']","this the address field",new Page.TypeOptions().setDelay(100));
        playwright.close();

    }

    @Test
    public void handlingTextBoxUsingFillMethod(){
        Playwright playwright=Playwright.create();
        Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)).newPage();
        page.navigate("https://dev.automationtesting.in/form");
        // fill() 1st method
        page.locator("//input[@name='firstName']").fill("test");

        // fill() overloaded 2nd method
        page.fill("//input[@name='lastName']","test");

        // fill() overloaded 3rd method - in this user can enter the text in text field slowly or set delay
        // as per need
        page.fill("//textarea[@name='address']","this the address field",new Page.FillOptions().setTimeout(100));
        playwright.close();




    }
}
