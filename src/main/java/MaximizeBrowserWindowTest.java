import com.microsoft.playwright.*;

import java.awt.*;

public class MaximizeBrowserWindowTest {

    public static void main(String []args){

        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        // In this we had hardcoded view port size
        BrowserContext context =browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,1810));
        Page page =context.newPage();
        page.navigate("https://www.amazon.in/");

        // If we had to know the view port size at run time, then we have to use Java class ToolKit

        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height=(int) dimension.getHeight();

        System.out.println("width "+width+" height "+height);
        BrowserContext contextOne =browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page pageOne =contextOne.newPage();
        pageOne.navigate("https://www.amazon.in/");

        pageOne.close();
        page.close();
        browser.close();
        playwright.close();

    }

}
